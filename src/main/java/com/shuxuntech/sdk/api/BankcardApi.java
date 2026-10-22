package com.shuxuntech.sdk.api;

import com.shuxuntech.sdk.ShuxunClient;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.Params;
import com.shuxuntech.sdk.model.result.BankPlaceResult;
import com.shuxuntech.sdk.model.result.Bankcard234Result;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 银行卡接口。
 *
 * <p>通过 {@link com.shuxuntech.sdk.ShuxunClient#apis()} 获取实例。</p>
 */
public final class BankcardApi {

    private final ShuxunClient client;

    public BankcardApi(ShuxunClient client) {
        this.client = client;
    }

    /**
     * 银行卡二要素核验。
     *
     * @param name 姓名
     * @param bankcard 银行卡号
     */
    public ApiResponse<Bankcard234Result> bankcard2Check(String name, String bankcard) {
        Params request = Params.create()
            .put("name", name)
            .put("bankcard", bankcard);
        return client.post("/v1/bankcard2/check", request, Bankcard234Result.class);
    }

    /**
     * 银行卡三要素核验。
     *
     * @param name 姓名
     * @param bankcard 银行卡号
     * @param idCard 身份证号
     */
    public ApiResponse<Bankcard234Result> bankcard3Check(String name, String bankcard, String idCard) {
        Params request = Params.create()
            .put("name", name)
            .put("bankcard", bankcard)
            .put("idCard", idCard);
        return client.post("/v1/bankcard3/check", request, Bankcard234Result.class);
    }

    /**
     * 银行卡三要素核验（手机号版）。
     *
     * @param name 姓名
     * @param bankcard 银行卡号
     * @param mobile 手机号
     */
    public ApiResponse<Bankcard234Result> bankcard3CheckV2(String name, String bankcard, String mobile) {
        Params request = Params.create()
            .put("name", name)
            .put("bankcard", bankcard)
            .put("mobile", mobile);
        return client.post("/v1/bankcard3/check/v2", request, Bankcard234Result.class);
    }

    /**
     * 银行卡四要素核验。
     *
     * @param name 姓名
     * @param bankcard 银行卡号
     * @param idCard 身份证号
     * @param mobile 手机号
     */
    public ApiResponse<Bankcard234Result> bankcard4Check(
            String name,
            String bankcard,
            String idCard,
            String mobile) {
        Params request = Params.create()
            .put("name", name)
            .put("bankcard", bankcard)
            .put("idCard", idCard)
            .put("mobile", mobile);
        return client.post("/v1/bankcard4/check", request, Bankcard234Result.class);
    }

    /**
     * 银行卡归属地查询。
     *
     * @param bankcard 银行卡号
     */
    public ApiResponse<BankPlaceResult> bankPlaceQuery(String bankcard) {
        Params request = Params.create()
            .put("bankcard", bankcard);
        return client.post("/v1/bankPlace/query", request, BankPlaceResult.class);
    }

    /**
     * 企业税务状态查询。
     *
     * @param acctNo 银行账号
     * @param acctBank 开户银行
     * @param entName 企业名称
     */
    public ApiResponse<JsonNode> entTaxStatusQuery(String acctNo, String acctBank, String entName) {
        Params request = Params.create()
            .put("acctNo", acctNo)
            .put("acctBank", acctBank)
            .put("entName", entName);
        return client.post("/v1/ent_tax_status/query", request);
    }

}
