package com.shuxuntech.sdk.exception;

import com.shuxuntech.sdk.model.ResponseCodes;

/**
 * 平台返回了明确的业务错误码（{@code code != 0}）时抛出。
 *
 * <p>只由 {@code postOrThrow} 系列方法抛出；直接使用 {@code post} 时，
 * 业务错误会以 {@code ApiResponse} 的形式正常返回，由调用方自行判断。</p>
 */
public class ShuxunApiException extends ShuxunException {

    private static final long serialVersionUID = 1L;

    private final int code;
    private final String msg;
    private final String seqNo;

    /**
     * @param code  平台返回码
     * @param msg   平台返回信息
     * @param seqNo 平台流水号，可能为 {@code null}
     */
    public ShuxunApiException(int code, String msg, String seqNo) {
        super(buildMessage(code, msg, seqNo));
        this.code = code;
        this.msg = msg;
        this.seqNo = seqNo;
    }

    private static String buildMessage(int code, String msg, String seqNo) {
        return "接口调用失败 code=" + code
                + "(" + ResponseCodes.describe(code) + ")"
                + ", msg=" + msg
                + (seqNo == null ? "" : ", seqNo=" + seqNo);
    }

    /**
     * 平台返回码，见 {@link ResponseCodes}。
     */
    public int getCode() {
        return code;
    }

    /**
     * 平台返回信息。
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 平台流水号，联系技术支持时提供。
     */
    public String getSeqNo() {
        return seqNo;
    }
}
