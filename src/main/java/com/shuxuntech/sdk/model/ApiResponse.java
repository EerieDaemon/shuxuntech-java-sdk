package com.shuxuntech.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 平台统一响应结构。
 *
 * <p>所有接口都返回同一层结构：</p>
 * <pre>{@code
 * {
 *   "code": 0,
 *   "msg": "成功",
 *   "seqNo": "20261022123456",
 *   "data": { ... }
 * }
 * }</pre>
 *
 * <p>{@code code = 0} 表示成功；其余取值见 {@link ResponseCodes}。
 * 注意 {@code code = 2}（无记录）属于正常业务返回，调用方应按业务含义处理。</p>
 *
 * <p>平台可能用非 2xx 的 HTTP 状态码返回业务错误（例如 400），此时响应体仍是本结构，
 * SDK 会照常解析并返回，{@link #getHttpStatus()} 保存原始状态码。</p>
 *
 * @param <T> 业务数据类型，无具体类型时可使用 {@code JsonNode}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {

    private Integer code;
    private String msg;
    private T data;
    private String seqNo;

    /** HTTP 状态码，由 SDK 填充，不参与 JSON 序列化。 */
    @JsonIgnore
    private Integer httpStatus;

    public ApiResponse() {
    }

    /**
     * 返回码，0 表示成功。响应缺失该字段时为 {@code null}。
     */
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 返回信息，失败时为具体错误描述。
     */
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 业务数据。
     */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 平台流水号，联系技术支持排查问题时提供。
     */
    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    /**
     * 本次请求的 HTTP 状态码，由 SDK 在解析响应后填充。
     *
     * <p>平台返回业务错误时状态码可能不是 200（例如 400、500），可据此区分
     * 业务失败与网关层错误；手工构造的对象该字段为 {@code null}。</p>
     */
    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    /**
     * 是否调用成功，即 {@code code == 0}。
     */
    public boolean isSuccess() {
        return code != null && code == 0;
    }

    @Override
    public String toString() {
        return "ApiResponse{httpStatus=" + httpStatus
                + ", code=" + code
                + ", msg='" + msg + '\''
                + ", seqNo='" + seqNo + '\''
                + '}';
    }
}
