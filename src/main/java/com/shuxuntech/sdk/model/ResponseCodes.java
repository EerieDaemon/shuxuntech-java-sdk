package com.shuxuntech.sdk.model;

/**
 * 平台统一返回码。
 *
 * <p>所有接口共用同一套返回码，出现在响应顶层 {@code code} 字段中。
 * {@link #SUCCESS} 表示成功，其余为失败；{@link #NO_RECORD} 属于正常业务结果。</p>
 *
 * @see <a href="https://shuxuntech.com/help#errorcode">错误码说明</a>
 */
public final class ResponseCodes {

    /** 成功。 */
    public static final int SUCCESS = 0;
    /** 参数错误：检查必填参数是否缺失、格式是否合法。 */
    public static final int PARAM_ERROR = 1;
    /** 无记录：权威库中未查到该条记录，属正常返回。 */
    public static final int NO_RECORD = 2;
    /** 第三方服务异常：上游通道波动，建议重试或联系技术支持。 */
    public static final int UPSTREAM_ERROR = 3;
    /** 签名错误：核对 appSecret，检查时间戳偏差是否超过 5 分钟。 */
    public static final int SIGN_ERROR = 4;
    /** 余额不足：前往控制台充值或购买新的套餐包。 */
    public static final int INSUFFICIENT_BALANCE = 5;
    /** 调用频率超限：降低并发或联系商务提升 QPS 上限。 */
    public static final int RATE_LIMITED = 6;
    /** 账号停用：联系客服核实账号状态。 */
    public static final int ACCOUNT_DISABLED = 7;
    /** 接口已停用：该接口已下线，请改用替代接口。 */
    public static final int API_DISABLED = 8;
    /** 未开通接口权限：在控制台申请开通该接口，或联系客服协助。 */
    public static final int API_NOT_AUTHORIZED = 9;
    /** IP 不在白名单：在控制台把调用方 IP 加入白名单。 */
    public static final int IP_NOT_ALLOWED = 10;
    /** 系统异常：服务端异常，请携带 seqNo 联系技术支持。 */
    public static final int SYSTEM_ERROR = 11;
    /** 实名状态错误：先完成企业实名认证再调用。 */
    public static final int REAL_NAME_REQUIRED = 12;
    /** 其他异常：以 msg 返回的具体信息为准。 */
    public static final int OTHER = 99;

    private ResponseCodes() {
    }

    /**
     * 返回返回码的中文说明；未知返回码返回 {@code "未知错误"}。
     *
     * @param code 平台返回码
     */
    public static String describe(int code) {
        switch (code) {
            case SUCCESS:
                return "成功";
            case PARAM_ERROR:
                return "参数错误";
            case NO_RECORD:
                return "无记录";
            case UPSTREAM_ERROR:
                return "第三方服务异常";
            case SIGN_ERROR:
                return "签名错误";
            case INSUFFICIENT_BALANCE:
                return "余额不足";
            case RATE_LIMITED:
                return "调用频率超限";
            case ACCOUNT_DISABLED:
                return "账号停用";
            case API_DISABLED:
                return "接口已停用";
            case API_NOT_AUTHORIZED:
                return "未开通接口权限";
            case IP_NOT_ALLOWED:
                return "IP 不在白名单";
            case SYSTEM_ERROR:
                return "系统异常";
            case REAL_NAME_REQUIRED:
                return "实名状态错误";
            case OTHER:
                return "其他异常";
            default:
                return "未知错误";
        }
    }
}
