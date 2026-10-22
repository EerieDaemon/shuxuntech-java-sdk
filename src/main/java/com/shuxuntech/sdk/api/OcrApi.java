package com.shuxuntech.sdk.api;

import com.shuxuntech.sdk.ShuxunClient;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.Params;
import com.shuxuntech.sdk.model.result.BankcardOcrResult;
import com.shuxuntech.sdk.model.result.BusinessOcrResult;
import com.shuxuntech.sdk.model.result.DrivingOcrResult;
import com.shuxuntech.sdk.model.result.IdCardOcrResult;
import com.shuxuntech.sdk.model.result.PlateOcrResult;
import com.shuxuntech.sdk.model.result.VehicleOcrResult;
import com.shuxuntech.sdk.model.result.VinOcrResult;
import com.shuxuntech.sdk.model.result.WordOcrResult;

/**
 * 文字识别接口。
 *
 * <p>通过 {@link com.shuxuntech.sdk.ShuxunClient#apis()} 获取实例。</p>
 */
public final class OcrApi {

    private final ShuxunClient client;

    public OcrApi(ShuxunClient client) {
        this.client = client;
    }

    /**
     * 身份证 OCR。
     *
     * @param image Base64 图片，与 imgUrl 二选一（可选）
     * @param imgUrl 图片 URL，与 image 二选一（可选）
     */
    public ApiResponse<IdCardOcrResult> idCardOcr(String image, String imgUrl) {
        Params request = Params.create()
            .put("image", image)
            .put("imgUrl", imgUrl);
        return client.post("/v1/idCard/ocr", request, IdCardOcrResult.class);
    }

    /**
     * 银行卡 OCR。
     *
     * @param image Base64 图片，与 imgUrl 二选一（可选）
     * @param imgUrl 图片 URL，与 image 二选一（可选）
     */
    public ApiResponse<BankcardOcrResult> bankcardOcr(String image, String imgUrl) {
        Params request = Params.create()
            .put("image", image)
            .put("imgUrl", imgUrl);
        return client.post("/v1/bankcard/ocr", request, BankcardOcrResult.class);
    }

    /**
     * 营业执照 OCR。
     *
     * @param image Base64 图片，与 imgUrl 二选一（可选）
     * @param imgUrl 图片 URL，与 image 二选一（可选）
     */
    public ApiResponse<BusinessOcrResult> businessOcr(String image, String imgUrl) {
        Params request = Params.create()
            .put("image", image)
            .put("imgUrl", imgUrl);
        return client.post("/v1/business/ocr", request, BusinessOcrResult.class);
    }

    /**
     * 驾驶证 OCR。
     *
     * @param image Base64 图片，与 imgUrl 二选一（可选）
     * @param imgUrl 图片 URL，与 image 二选一（可选）
     */
    public ApiResponse<DrivingOcrResult> drivingOcr(String image, String imgUrl) {
        Params request = Params.create()
            .put("image", image)
            .put("imgUrl", imgUrl);
        return client.post("/v1/driving/ocr", request, DrivingOcrResult.class);
    }

    /**
     * 车牌号 OCR。
     *
     * @param image Base64 图片，与 imgUrl 二选一（可选）
     * @param imgUrl 图片 URL，与 image 二选一（可选）
     */
    public ApiResponse<PlateOcrResult> plateOcr(String image, String imgUrl) {
        Params request = Params.create()
            .put("image", image)
            .put("imgUrl", imgUrl);
        return client.post("/v1/plate/ocr", request, PlateOcrResult.class);
    }

    /**
     * 行驶证 OCR。
     *
     * @param image Base64 图片，与 imgUrl 二选一（可选）
     * @param imgUrl 图片 URL，与 image 二选一（可选）
     * @param cardSide 证件面：FRONT / BACK，默认 FRONT（可选）
     */
    public ApiResponse<VehicleOcrResult> vehicleOcr(String image, String imgUrl, String cardSide) {
        Params request = Params.create()
            .put("image", image)
            .put("imgUrl", imgUrl)
            .put("cardSide", cardSide);
        return client.post("/v1/vehicle/ocr", request, VehicleOcrResult.class);
    }

    /**
     * 通用文字 OCR。
     *
     * @param image Base64 图片，与 imgUrl 二选一（可选）
     * @param imgUrl 图片 URL，与 image 二选一（可选）
     */
    public ApiResponse<WordOcrResult> wordOcr(String image, String imgUrl) {
        Params request = Params.create()
            .put("image", image)
            .put("imgUrl", imgUrl);
        return client.post("/v1/word/ocr", request, WordOcrResult.class);
    }

    /**
     * 车架号 OCR。
     *
     * @param image Base64 图片，与 imgUrl 二选一（可选）
     * @param imgUrl 图片 URL，与 image 二选一（可选）
     */
    public ApiResponse<VinOcrResult> vinOcr(String image, String imgUrl) {
        Params request = Params.create()
            .put("image", image)
            .put("imgUrl", imgUrl);
        return client.post("/v1/vin/ocr", request, VinOcrResult.class);
    }

}
