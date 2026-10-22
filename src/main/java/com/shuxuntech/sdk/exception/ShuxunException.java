package com.shuxuntech.sdk.exception;

/**
 * SDK 所有异常的父类，继承 {@link RuntimeException}，不强制捕获。
 */
public class ShuxunException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ShuxunException(String message) {
        super(message);
    }

    public ShuxunException(String message, Throwable cause) {
        super(message, cause);
    }
}
