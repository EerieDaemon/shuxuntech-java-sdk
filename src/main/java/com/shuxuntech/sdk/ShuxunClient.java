package com.shuxuntech.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.shuxuntech.sdk.auth.Signature;
import com.shuxuntech.sdk.exception.ShuxunApiException;
import com.shuxuntech.sdk.exception.ShuxunTransportException;
import com.shuxuntech.sdk.http.HttpResponse;
import com.shuxuntech.sdk.http.HttpTransport;
import com.shuxuntech.sdk.http.OkHttpTransport;
import com.shuxuntech.sdk.internal.Json;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.Params;

import java.io.Closeable;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 数勋科技开放平台 Java 客户端，线程安全，建议全局复用同一个实例。
 *
 * <p>每个请求自动完成：</p>
 * <ol>
 *     <li>以毫秒时间戳生成 {@code timestamp}；</li>
 *     <li>按 {@code sha256(appKey + timestamp + appSecret)} 生成 {@code sign}；</li>
 *     <li>把 {@code appKey}、{@code timestamp}、{@code sign} 放入请求头；</li>
 *     <li>把参数按 {@code application/x-www-form-urlencoded} 提交，并把响应解析为
 *     {@link ApiResponse}。</li>
 * </ol>
 *
 * <p>最简用法：</p>
 * <pre>{@code
 * ShuxunClient client = ShuxunClient.builder()
 *         .appKey("your-app-key")
 *         .appSecret("your-app-secret")
 *         .build();
 *
 * ApiResponse<JsonNode> response = client.post("/your/api/path",
 *         Params.create().put("name", "张三"));
 * if (response.isSuccess()) {
 *     JsonNode data = response.getData();
 * }
 * }</pre>
 *
 * <p>SDK 不会自动重试：平台接口通常按次计费，是否重试应由业务决定。
 * 业务错误（{@code code != 0}）默认通过返回值表达，需要抛出异常时使用
 * {@code postOrThrow} 系列方法。</p>
 *
 * <p>平台可能用非 2xx 的 HTTP 状态码返回业务错误（例如 400），但只要响应体仍是
 * 统一结构（含 {@code code} 字段），SDK 就会照常解析并返回，原始状态码可通过
 * {@link ApiResponse#getHttpStatus()} 获取；只有响应体无法识别为平台响应时才会抛出
 * {@link ShuxunTransportException}。</p>
 */
public final class ShuxunClient implements Closeable {

    /**
     * 默认网关地址。不同接口可能使用不同网关，可在 {@link Builder#baseUrl(String)} 中覆盖。
     */
    public static final String DEFAULT_BASE_URL = "https://api.shuxuntech.com";

    /** 请求头：应用标识。 */
    public static final String HEADER_APP_KEY = "appKey";
    /** 请求头：毫秒时间戳。 */
    public static final String HEADER_TIMESTAMP = "timestamp";
    /** 请求头：SHA-256 签名。 */
    public static final String HEADER_SIGN = "sign";

    private static final Duration DEFAULT_CONNECT_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration DEFAULT_READ_TIMEOUT = Duration.ofSeconds(15);
    private static final Duration DEFAULT_WRITE_TIMEOUT = Duration.ofSeconds(15);

    private final String baseUrl;
    private final String appKey;
    private final String appSecret;
    private final HttpTransport transport;
    private final boolean ownsTransport;
    private final ShuxunApis apis;

    private ShuxunClient(Builder builder) {
        this.baseUrl = stripTrailingSlash(builder.baseUrl);
        this.appKey = builder.appKey;
        this.appSecret = builder.appSecret;
        if (builder.transport != null) {
            this.transport = builder.transport;
            this.ownsTransport = false;
        } else {
            this.transport = OkHttpTransport.of(
                    builder.connectTimeout, builder.readTimeout, builder.writeTimeout);
            this.ownsTransport = true;
        }
        this.apis = new ShuxunApis(this);
    }

    /**
     * 创建构建器。
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * 使用默认配置创建客户端，网关地址取 {@link #DEFAULT_BASE_URL}。
     *
     * @param appKey    应用 appKey
     * @param appSecret 应用 appSecret
     */
    public static ShuxunClient create(String appKey, String appSecret) {
        return builder().appKey(appKey).appSecret(appSecret).build();
    }

    /**
     * 调用接口，业务数据以 {@link JsonNode} 返回，不做强类型映射。
     *
     * @param path   接口路径，如 {@code "/v1/ocr/idcard"}
     * @param params 表单参数，可为 {@code null}
     * @return 统一响应，业务错误以 {@code code} 表达
     */
    public ApiResponse<JsonNode> post(String path, Params params) {
        return post(path, params, JsonNode.class);
    }

    /**
     * 调用接口，并把 {@code data} 映射为指定类型。
     *
     * @param path     接口路径
     * @param params   表单参数，可为 {@code null}
     * @param dataType {@code data} 的目标类型
     * @param <T>      业务数据类型
     */
    public <T> ApiResponse<T> post(String path, Params params, Class<T> dataType) {
        if (dataType == null) {
            throw new IllegalArgumentException("dataType 不能为空");
        }
        JavaType type = Json.mapper().getTypeFactory()
                .constructParametricType(ApiResponse.class, dataType);
        return execute(path, params, type);
    }

    /**
     * 调用接口，并把 {@code data} 映射为泛型类型（如 {@code List<Item>}）。
     *
     * @param path     接口路径
     * @param params   表单参数，可为 {@code null}
     * @param dataType {@code data} 的目标类型
     * @param <T>      业务数据类型
     */
    public <T> ApiResponse<T> post(String path, Params params, TypeReference<T> dataType) {
        if (dataType == null) {
            throw new IllegalArgumentException("dataType 不能为空");
        }
        JavaType type = Json.mapper().getTypeFactory()
                .constructParametricType(ApiResponse.class,
                        Json.mapper().getTypeFactory().constructType(dataType));
        return execute(path, params, type);
    }

    /**
     * 调用接口，业务数据以 {@link JsonNode} 返回；{@code code != 0} 时抛出
     * {@link ShuxunApiException}。
     */
    public ApiResponse<JsonNode> postOrThrow(String path, Params params) {
        return postOrThrow(path, params, JsonNode.class);
    }

    /**
     * 调用接口并映射 {@code data}；{@code code != 0} 时抛出 {@link ShuxunApiException}。
     */
    public <T> ApiResponse<T> postOrThrow(String path, Params params, Class<T> dataType) {
        return checkSuccess(post(path, params, dataType));
    }

    /**
     * 调用接口并映射泛型 {@code data}；{@code code != 0} 时抛出 {@link ShuxunApiException}。
     */
    public <T> ApiResponse<T> postOrThrow(String path, Params params, TypeReference<T> dataType) {
        return checkSuccess(post(path, params, dataType));
    }

    /**
     * 当前使用的网关地址。
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * 按业务分类的强类型接口集合，例如 {@code client.apis().identity().idCardCheck(...)}。
     */
    public ShuxunApis apis() {
        return apis;
    }

    /**
     * 当前使用的 appKey。
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * 关闭内部创建的连接池。注入自定义传输层时由调用方负责关闭。
     */
    @Override
    public void close() {
        if (ownsTransport) {
            try {
                transport.close();
            } catch (IOException ignored) {
                // 关闭失败不影响调用方
            }
        }
    }

    private <T> ApiResponse<T> execute(String path, Params params, JavaType responseType) {
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("path 不能为空");
        }

        long timestamp = System.currentTimeMillis();
        Map<String, String> headers = new LinkedHashMap<String, String>();
        headers.put(HEADER_APP_KEY, appKey);
        headers.put(HEADER_TIMESTAMP, Long.toString(timestamp));
        headers.put(HEADER_SIGN, Signature.sign(appKey, appSecret, timestamp));

        Map<String, String> form = params == null
                ? Collections.<String, String>emptyMap()
                : params.asMap();
        String url = buildUrl(path);

        HttpResponse response;
        try {
            response = transport.post(url, headers, form);
        } catch (IOException e) {
            throw new ShuxunTransportException("请求 " + url + " 失败: " + e.getMessage(), e);
        }

        int status = response.getStatus();
        String body = response.getBody();
        boolean httpSuccess = status >= 200 && status < 300;

        if (body == null || body.trim().isEmpty()) {
            throw new ShuxunTransportException(status, "HTTP " + status + " 响应内容为空");
        }

        ApiResponse<T> result = null;
        IOException parseError = null;
        try {
            result = Json.mapper().readValue(body, responseType);
        } catch (IOException e) {
            parseError = e;
        }

        // 平台把业务错误也放在统一响应体里返回，HTTP 状态可能不是 2xx（例如 400/500）。
        // 只要响应体是平台统一结构（含 code 字段），就照常返回给调用方，由 code 表达结果。
        if (result == null || result.getCode() == null) {
            if (!httpSuccess) {
                throw new ShuxunTransportException(status,
                        "HTTP " + status + "，响应不是平台统一结构: " + abbreviate(body, 512), body, parseError);
            }
            if (parseError != null) {
                throw new ShuxunTransportException(status,
                        "响应不是合法的 JSON: " + abbreviate(body, 512), body, parseError);
            }
            if (result == null) {
                throw new ShuxunTransportException(status, "响应无法解析: " + abbreviate(body, 512), body);
            }
            // 2xx 但缺少 code 字段：仍返回，isSuccess() 为 false
            result.setHttpStatus(status);
            return result;
        }

        result.setHttpStatus(status);
        return result;
    }

    private static <T> ApiResponse<T> checkSuccess(ApiResponse<T> response) {
        if (!response.isSuccess()) {
            int code = response.getCode() == null ? -1 : response.getCode();
            throw new ShuxunApiException(code, response.getMsg(), response.getSeqNo());
        }
        return response;
    }

    private String buildUrl(String path) {
        return path.startsWith("/") ? baseUrl + path : baseUrl + "/" + path;
    }

    private static String stripTrailingSlash(String value) {
        String result = value.trim();
        while (result.endsWith("/")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    private static String abbreviate(String text, int maxLength) {
        if (text == null) {
            return "";
        }
        String trimmed = text.trim();
        return trimmed.length() <= maxLength ? trimmed : trimmed.substring(0, maxLength) + "...";
    }

    private static void requireText(String value, String name) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(name + " 不能为空");
        }
    }

    /**
     * {@link ShuxunClient} 构建器。
     */
    public static final class Builder {

        private String baseUrl = DEFAULT_BASE_URL;
        private String appKey;
        private String appSecret;
        private Duration connectTimeout = DEFAULT_CONNECT_TIMEOUT;
        private Duration readTimeout = DEFAULT_READ_TIMEOUT;
        private Duration writeTimeout = DEFAULT_WRITE_TIMEOUT;
        private HttpTransport transport;

        private Builder() {
        }

        /**
         * 网关地址，默认 {@link ShuxunClient#DEFAULT_BASE_URL}。
         */
        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        /**
         * 应用的 appKey，必填。
         */
        public Builder appKey(String appKey) {
            this.appKey = appKey;
            return this;
        }

        /**
         * 应用的 appSecret，必填，请勿写入代码仓库。
         */
        public Builder appSecret(String appSecret) {
            this.appSecret = appSecret;
            return this;
        }

        /**
         * 连接超时，默认 5 秒。
         */
        public Builder connectTimeout(Duration connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        /**
         * 读取超时，默认 15 秒。
         */
        public Builder readTimeout(Duration readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        /**
         * 写入超时，默认 15 秒。
         */
        public Builder writeTimeout(Duration writeTimeout) {
            this.writeTimeout = writeTimeout;
            return this;
        }

        /**
         * 自定义传输层，注入后由调用方负责关闭。
         */
        public Builder transport(HttpTransport transport) {
            this.transport = transport;
            return this;
        }

        /**
         * 创建客户端。
         *
         * @throws IllegalArgumentException 必填项缺失或超时时间非法
         */
        public ShuxunClient build() {
            requireText(appKey, "appKey");
            requireText(appSecret, "appSecret");
            requireText(baseUrl, "baseUrl");
            requirePositive(connectTimeout, "connectTimeout");
            requirePositive(readTimeout, "readTimeout");
            requirePositive(writeTimeout, "writeTimeout");
            return new ShuxunClient(this);
        }

        private static void requirePositive(Duration duration, String name) {
            if (duration == null || duration.isNegative() || duration.isZero()) {
                throw new IllegalArgumentException(name + " 必须大于 0");
            }
        }
    }
}
