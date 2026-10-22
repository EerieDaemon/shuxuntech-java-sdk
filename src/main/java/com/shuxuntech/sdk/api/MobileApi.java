package com.shuxuntech.sdk.api;

import com.shuxuntech.sdk.ShuxunClient;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.Params;
import com.shuxuntech.sdk.model.result.Mobile23Result;
import com.shuxuntech.sdk.model.result.MobileEmptyResult;
import com.shuxuntech.sdk.model.result.MobileEmptyResultV2;
import com.shuxuntech.sdk.model.result.MobileOnlineResult;
import com.shuxuntech.sdk.model.result.MobileStatusResult;
import com.shuxuntech.sdk.model.result.MobileTransformResult;

/**
 * 运营商接口。
 *
 * <p>通过 {@link com.shuxuntech.sdk.ShuxunClient#apis()} 获取实例。</p>
 */
public final class MobileApi {

    private final ShuxunClient client;

    public MobileApi(ShuxunClient client) {
        this.client = client;
    }

    /**
     * 手机号二要素核验。
     *
     * @param name 姓名
     * @param mobile 手机号
     */
    public ApiResponse<Mobile23Result> mobile2Check(String name, String mobile) {
        Params request = Params.create()
            .put("name", name)
            .put("mobile", mobile);
        return client.post("/v1/mobile2/check", request, Mobile23Result.class);
    }

    /**
     * 手机号三要素核验。
     *
     * @param name 姓名
     * @param mobile 手机号
     * @param idCard 身份证号
     */
    public ApiResponse<Mobile23Result> mobile3Check(String name, String mobile, String idCard) {
        Params request = Params.create()
            .put("name", name)
            .put("mobile", mobile)
            .put("idCard", idCard);
        return client.post("/v1/mobile3/check", request, Mobile23Result.class);
    }

    /**
     * 空号检测。
     *
     * @param mobile 手机号
     */
    public ApiResponse<MobileEmptyResult> mobileEmptyCheck(String mobile) {
        Params request = Params.create()
            .put("mobile", mobile);
        return client.post("/v1/mobileEmpty/check", request, MobileEmptyResult.class);
    }

    /**
     * 空号检测 V2。
     *
     * @param mobile 手机号
     */
    public ApiResponse<MobileEmptyResultV2> mobileEmptyCheckV2(String mobile) {
        Params request = Params.create()
            .put("mobile", mobile);
        return client.post("/v1/mobileEmpty/check/v2", request, MobileEmptyResultV2.class);
    }

    /**
     * 空号检测 V3（入口已存在，能否调用以控制台开通为准）。
     *
     * @param mobile 手机号
     */
    public ApiResponse<MobileEmptyResultV2> mobileEmptyCheckV3(String mobile) {
        Params request = Params.create()
            .put("mobile", mobile);
        return client.post("/v1/mobileEmpty/check/v3", request, MobileEmptyResultV2.class);
    }

    /**
     * 手机号在网时长查询。
     *
     * @param mobile 手机号
     */
    public ApiResponse<MobileOnlineResult> mobileOnlineQuery(String mobile) {
        Params request = Params.create()
            .put("mobile", mobile);
        return client.post("/v1/mobileOnline/query", request, MobileOnlineResult.class);
    }

    /**
     * 手机号状态查询。
     *
     * @param mobile 手机号
     */
    public ApiResponse<MobileStatusResult> mobileStatusQuery(String mobile) {
        Params request = Params.create()
            .put("mobile", mobile);
        return client.post("/v1/mobileStatus/query", request, MobileStatusResult.class);
    }

    /**
     * 携号转网查询。
     *
     * @param mobile 手机号
     */
    public ApiResponse<MobileTransformResult> mobileTransformQuery(String mobile) {
        Params request = Params.create()
            .put("mobile", mobile);
        return client.post("/v1/mobileTransform/query", request, MobileTransformResult.class);
    }

}
