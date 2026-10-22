package com.shuxuntech.sdk.exception;

/**
 * 网络不可达、HTTP 状态非 2xx、响应不是合法 JSON 等传输层异常。
 *
 * <p>SDK 不会自动重试：平台接口通常按次计费，重试前请先确认业务是否可以重复调用。</p>
 */
public class ShuxunTransportException extends ShuxunException {

    private static final long serialVersionUID = 1L;

    private final int httpStatus;

    /**
     * 未拿到 HTTP 响应（例如连接失败、超时）。
     */
    public ShuxunTransportException(String message, Throwable cause) {
        this(0, message, cause);
    }

    /**
     * 拿到了 HTTP 响应，但状态码非 2xx 或响应内容不可用。
     *
     * @param httpStatus HTTP 状态码
     */
    public ShuxunTransportException(int httpStatus, String message) {
        this(httpStatus, message, null);
    }

    public ShuxunTransportException(int httpStatus, String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    /**
     * HTTP 状态码，未拿到响应时为 0。
     */
    public int getHttpStatus() {
        return httpStatus;
    }
}
