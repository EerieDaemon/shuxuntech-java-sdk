package com.shuxuntech.sdk.api;

import com.shuxuntech.sdk.ShuxunClient;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.Params;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 短信接口。
 *
 * <p>通过 {@link com.shuxuntech.sdk.ShuxunClient#apis()} 获取实例。</p>
 */
public final class SmsApi {

    private final ShuxunClient client;

    public SmsApi(ShuxunClient client) {
        this.client = client;
    }

    /**
     * 发送 70 字短信。
     *
     * @param templateNo 短信模板编号
     * @param mobile 手机号
     * @param vars 短信变量，多个变量用 | 分隔（可选）
     * @param sendTime 定时发送时间，格式 yyyyMMddHHmmss（可选）
     * @param businessId 商户编号，一般无需传（可选）
     * @param businessName 商户名称，一般无需传（可选）
     * @param ip 调用方 IP（可选）
     */
    public ApiResponse<JsonNode> sms70Send(
            String templateNo,
            String mobile,
            String vars,
            String sendTime,
            Integer businessId,
            String businessName,
            String ip) {
        Params request = Params.create()
            .put("templateNo", templateNo)
            .put("mobile", mobile)
            .put("vars", vars)
            .put("sendTime", sendTime)
            .put("businessId", businessId)
            .put("businessName", businessName)
            .put("ip", ip);
        return client.post("/v1/sms_70/send", request);
    }

    /**
     * 发送 70 字短信，只传必填参数。
     *
     * @param templateNo 短信模板编号
     * @param mobile 手机号
     */
    public ApiResponse<JsonNode> sms70Send(String templateNo, String mobile) {
        return sms70Send(templateNo, mobile, null, null, null, null, null);
    }

    /**
     * 发送 134 字短信。
     *
     * @param templateNo 短信模板编号
     * @param mobile 手机号
     * @param vars 短信变量，多个变量用 | 分隔（可选）
     * @param sendTime 定时发送时间，格式 yyyyMMddHHmmss（可选）
     * @param businessId 商户编号，一般无需传（可选）
     * @param businessName 商户名称，一般无需传（可选）
     * @param ip 调用方 IP（可选）
     */
    public ApiResponse<JsonNode> sms134Send(
            String templateNo,
            String mobile,
            String vars,
            String sendTime,
            Integer businessId,
            String businessName,
            String ip) {
        Params request = Params.create()
            .put("templateNo", templateNo)
            .put("mobile", mobile)
            .put("vars", vars)
            .put("sendTime", sendTime)
            .put("businessId", businessId)
            .put("businessName", businessName)
            .put("ip", ip);
        return client.post("/v1/sms_134/send", request);
    }

    /**
     * 发送 134 字短信，只传必填参数。
     *
     * @param templateNo 短信模板编号
     * @param mobile 手机号
     */
    public ApiResponse<JsonNode> sms134Send(String templateNo, String mobile) {
        return sms134Send(templateNo, mobile, null, null, null, null, null);
    }

    /**
     * 发送 201 字短信。
     *
     * @param templateNo 短信模板编号
     * @param mobile 手机号
     * @param vars 短信变量，多个变量用 | 分隔（可选）
     * @param sendTime 定时发送时间，格式 yyyyMMddHHmmss（可选）
     * @param businessId 商户编号，一般无需传（可选）
     * @param businessName 商户名称，一般无需传（可选）
     * @param ip 调用方 IP（可选）
     */
    public ApiResponse<JsonNode> sms201Send(
            String templateNo,
            String mobile,
            String vars,
            String sendTime,
            Integer businessId,
            String businessName,
            String ip) {
        Params request = Params.create()
            .put("templateNo", templateNo)
            .put("mobile", mobile)
            .put("vars", vars)
            .put("sendTime", sendTime)
            .put("businessId", businessId)
            .put("businessName", businessName)
            .put("ip", ip);
        return client.post("/v1/sms_201/send", request);
    }

    /**
     * 发送 201 字短信，只传必填参数。
     *
     * @param templateNo 短信模板编号
     * @param mobile 手机号
     */
    public ApiResponse<JsonNode> sms201Send(String templateNo, String mobile) {
        return sms201Send(templateNo, mobile, null, null, null, null, null);
    }

}
