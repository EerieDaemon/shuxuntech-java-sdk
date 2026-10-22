package com.shuxuntech.sdk.http;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 基于 OkHttp 的默认传输层实现。
 *
 * <p>内部复用同一个 {@link OkHttpClient}，支持连接池与 HTTP/2，可安全地在多线程间共享。</p>
 */
public final class OkHttpTransport implements HttpTransport {

    private final OkHttpClient client;

    /**
     * 使用调用方提供的 OkHttpClient，便于复用已有连接池、代理或拦截器。
     */
    public OkHttpTransport(OkHttpClient client) {
        if (client == null) {
            throw new IllegalArgumentException("client 不能为空");
        }
        this.client = client;
    }

    /**
     * 按超时时间创建传输层。
     *
     * @param connectTimeout 连接超时
     * @param readTimeout    读取超时
     * @param writeTimeout   写入超时
     */
    public static OkHttpTransport of(Duration connectTimeout, Duration readTimeout, Duration writeTimeout) {
        if (connectTimeout == null || readTimeout == null || writeTimeout == null) {
            throw new IllegalArgumentException("超时时间不能为空");
        }
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(connectTimeout.toMillis(), TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout.toMillis(), TimeUnit.MILLISECONDS)
                .writeTimeout(writeTimeout.toMillis(), TimeUnit.MILLISECONDS)
                .build();
        return new OkHttpTransport(client);
    }

    @Override
    public HttpResponse post(String url, Map<String, String> headers, Map<String, String> form) throws IOException {
        FormBody.Builder body = new FormBody.Builder();
        if (form != null) {
            for (Map.Entry<String, String> entry : form.entrySet()) {
                body.add(entry.getKey(), entry.getValue() == null ? "" : entry.getValue());
            }
        }

        Request.Builder request = new Request.Builder()
                .url(url)
                .post(body.build());
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue());
            }
        }

        try (Response response = client.newCall(request.build()).execute()) {
            ResponseBody responseBody = response.body();
            String text = responseBody == null ? "" : responseBody.string();
            return new HttpResponse(response.code(), text, response.headers().toMultimap());
        }
    }

    @Override
    public void close() {
        client.dispatcher().executorService().shutdown();
        client.connectionPool().evictAll();
    }
}
