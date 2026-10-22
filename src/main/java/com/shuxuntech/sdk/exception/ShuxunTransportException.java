package com.shuxuntech.sdk.exception;

/**
 * 网络不可达、响应不是平台统一结构等传输层异常。
 *
 * <p>注意：平台会把业务错误（参数错误、签名错误、无权限等）放在统一响应体中返回，
 * HTTP 状态码可能不是 2xx。只要响应体包含顶层 {@code code} 字段，SDK 就会正常返回
 * {@code ApiResponse}，不会抛出本异常；只有响应体无法识别为平台响应（例如网关返回
 * 的 HTML 错误页）时才会抛出。</p>
 *
 * <p>SDK 不会自动重试：平台接口通常按次计费，重试前请先确认业务是否可以重复调用。</p>
 */
public class ShuxunTransportException extends ShuxunException {

    private static final long serialVersionUID = 1L;

    private final int httpStatus;
    private final String responseBody;

    /**
     * 未拿到 HTTP 响应（例如连接失败、超时）。
     */
    public ShuxunTransportException(String message, Throwable cause) {
        this(0, message, null, cause);
    }

    /**
     * 拿到了 HTTP 响应，但响应内容不可用。
     *
     * @param httpStatus HTTP 状态码
     */
    public ShuxunTransportException(int httpStatus, String message) {
        this(httpStatus, message, null, null);
    }

    public ShuxunTransportException(int httpStatus, String message, Throwable cause) {
        this(httpStatus, message, null, cause);
    }

    /**
     * 拿到了 HTTP 响应，但响应体无法识别为平台统一结构。
     *
     * @param httpStatus   HTTP 状态码
     * @param message      异常描述
     * @param responseBody 原始响应体，便于调用方自行排查
     */
    public ShuxunTransportException(int httpStatus, String message, String responseBody) {
        this(httpStatus, message, responseBody, null);
    }

    public ShuxunTransportException(int httpStatus, String message, String responseBody, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
        this.responseBody = responseBody;
    }

    /**
     * HTTP 状态码，未拿到响应时为 0。
     */
    public int getHttpStatus() {
        return httpStatus;
    }

    /**
     * 原始响应体，未拿到响应或响应为空时为 {@code null}。
     */
    public String getResponseBody() {
        return responseBody;
    }
}
