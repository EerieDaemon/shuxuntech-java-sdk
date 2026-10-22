package com.shuxuntech.sdk.api;

import com.shuxuntech.sdk.ShuxunClient;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.Params;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 生活服务接口。
 *
 * <p>通过 {@link com.shuxuntech.sdk.ShuxunClient#apis()} 获取实例。</p>
 */
public final class ExpressApi {

    private final ShuxunClient client;

    public ExpressApi(ShuxunClient client) {
        this.client = client;
    }

    /**
     * 快递物流查询。
     *
     * @param no 快递单号
     * @param code 快递公司编码，不传时由平台自动识别（可选）
     * @param tel 收件人手机号后四位（顺丰等部分快递必填）（可选）
     */
    public ApiResponse<JsonNode> expressQuery(String no, String code, String tel) {
        Params request = Params.create()
            .put("no", no)
            .put("code", code)
            .put("tel", tel);
        return client.post("/v1/express/query", request);
    }

    /**
     * 快递物流查询，只传必填参数。
     *
     * @param no 快递单号
     */
    public ApiResponse<JsonNode> expressQuery(String no) {
        return expressQuery(no, null, null);
    }

    /**
     * 快递物流订阅。
     *
     * @param no 快递单号
     * @param callbackUrl 物流订阅回调地址
     * @param code 快递公司编码，不传时由平台自动识别（可选）
     * @param tel 收件人手机号后四位（顺丰等部分快递必填）（可选）
     */
    public ApiResponse<JsonNode> expressSubscribe(String no, String callbackUrl, String code, String tel) {
        Params request = Params.create()
            .put("no", no)
            .put("callbackUrl", callbackUrl)
            .put("code", code)
            .put("tel", tel);
        return client.post("/v1/express/subscribe", request);
    }

    /**
     * 快递物流订阅，只传必填参数。
     *
     * @param no 快递单号
     * @param callbackUrl 物流订阅回调地址
     */
    public ApiResponse<JsonNode> expressSubscribe(String no, String callbackUrl) {
        return expressSubscribe(no, callbackUrl, null, null);
    }

}
