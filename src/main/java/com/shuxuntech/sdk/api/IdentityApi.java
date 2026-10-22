package com.shuxuntech.sdk.api;

import com.shuxuntech.sdk.ShuxunClient;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.Params;
import com.shuxuntech.sdk.model.result.FaceCompareResult;
import com.shuxuntech.sdk.model.result.FaceIdCardResult;
import com.shuxuntech.sdk.model.result.IdCardCheckResult;
import com.shuxuntech.sdk.model.result.LivingCheckResult;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 身份核验接口。
 *
 * <p>通过 {@link com.shuxuntech.sdk.ShuxunClient#apis()} 获取实例。</p>
 */
public final class IdentityApi {

    private final ShuxunClient client;

    public IdentityApi(ShuxunClient client) {
        this.client = client;
    }

    /**
     * 身份证实名核验。
     *
     * @param name 姓名
     * @param idCard 身份证号
     */
    public ApiResponse<IdCardCheckResult> idCardCheck(String name, String idCard) {
        Params request = Params.create()
            .put("name", name)
            .put("idCard", idCard);
        return client.post("/v1/idCard/check", request, IdCardCheckResult.class);
    }

    /**
     * 人脸与身份证比对（同一实现也挂在 /v1/faceIdCard/check）。
     *
     * @param name 姓名
     * @param idCard 身份证号
     * @param image Base64 图片，与 imgUrl 二选一（可选）
     * @param imgUrl 图片 URL，与 image 二选一（可选）
     */
    public ApiResponse<FaceIdCardResult> faceIdCardCheck(String name, String idCard, String image, String imgUrl) {
        Params request = Params.create()
            .put("name", name)
            .put("idCard", idCard)
            .put("image", image)
            .put("imgUrl", imgUrl);
        return client.post("/v1/faceIdCard/check/yisuo", request, FaceIdCardResult.class);
    }

    /**
     * 人脸与身份证比对（同一实现也挂在 /v1/faceIdCard/check），只传必填参数。
     *
     * @param name 姓名
     * @param idCard 身份证号
     */
    public ApiResponse<FaceIdCardResult> faceIdCardCheck(String name, String idCard) {
        return faceIdCardCheck(name, idCard, null, null);
    }

    /**
     * 两张人脸比对，两张图片可传 Base64 或 URL。
     *
     * @param image1 第一张图片（Base64 或 URL）（可选）
     * @param image2 第二张图片（Base64 或 URL）（可选）
     * @param imgUrl1 第一张图片 URL（可选）
     * @param imgUrl2 第二张图片 URL（可选）
     */
    public ApiResponse<FaceCompareResult> faceCompare(
            String image1,
            String image2,
            String imgUrl1,
            String imgUrl2) {
        Params request = Params.create()
            .put("image1", image1)
            .put("image2", image2)
            .put("imgUrl1", imgUrl1)
            .put("imgUrl2", imgUrl2);
        return client.post("/v1/faceCompare/check", request, FaceCompareResult.class);
    }

    /**
     * 图片活体检测。
     *
     * @param image1 第一张图片（Base64 或 URL）
     * @param image2 第二张图片（Base64 或 URL）（可选）
     * @param image3 第三张图片（Base64 或 URL）（可选）
     */
    public ApiResponse<LivingCheckResult> livingCheck(String image1, String image2, String image3) {
        Params request = Params.create()
            .put("image1", image1)
            .put("image2", image2)
            .put("image3", image3);
        return client.post("/v1/living/check", request, LivingCheckResult.class);
    }

    /**
     * 图片活体检测，只传必填参数。
     *
     * @param image1 第一张图片（Base64 或 URL）
     */
    public ApiResponse<LivingCheckResult> livingCheck(String image1) {
        return livingCheck(image1, null, null);
    }

    /**
     * 查询 SDK 活体检测结果。
     *
     * @param certifyId SDK 活体认证标识
     * @param sdkAppId 控制台创建的 SDK AppId
     */
    public ApiResponse<JsonNode> livingSdkCheck(String certifyId, String sdkAppId) {
        Params request = Params.create()
            .put("certifyId", certifyId)
            .put("sdkAppId", sdkAppId);
        return client.post("/v1/living_sdk/check", request);
    }

}
