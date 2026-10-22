package com.shuxuntech.sdk.api;

import com.shuxuntech.sdk.ShuxunClient;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.Params;
import com.shuxuntech.sdk.model.result.CarFiveResult;
import com.shuxuntech.sdk.model.result.Vin2_1Result;
import com.shuxuntech.sdk.model.result.Vin5Result;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 交通出行接口。
 *
 * <p>通过 {@link com.shuxuntech.sdk.ShuxunClient#apis()} 获取实例。</p>
 */
public final class VehicleApi {

    private final ShuxunClient client;

    public VehicleApi(ShuxunClient client) {
        this.client = client;
    }

    /**
     * 车架号 VIN 查询。
     *
     * @param vin 车架号
     */
    public ApiResponse<JsonNode> vinQuery(String vin) {
        Params request = Params.create()
            .put("vin", vin);
        return client.post("/v1/vin/query", request);
    }

    /**
     * 车架号 VIN 查询 V2.1。
     *
     * @param vin 车架号
     */
    public ApiResponse<Vin2_1Result> vin21Query(String vin) {
        Params request = Params.create()
            .put("vin", vin);
        return client.post("/v1/vin2_1/query", request, Vin2_1Result.class);
    }

    /**
     * 车架号 VIN 查询 V3。
     *
     * @param vin 车架号
     */
    public ApiResponse<JsonNode> vin3Query(String vin) {
        Params request = Params.create()
            .put("vin", vin);
        return client.post("/v1/vin3/query", request);
    }

    /**
     * 车架号 VIN 查询 V4（定制）。
     *
     * @param vin 车架号
     */
    public ApiResponse<JsonNode> vin4CustomQuery(String vin) {
        Params request = Params.create()
            .put("vin", vin);
        return client.post("/v1/vin4_custom/query", request);
    }

    /**
     * 车架号 VIN 查询 V5（精准版，含公告号）。
     *
     * @param vin 车架号
     */
    public ApiResponse<Vin5Result> vin5Query(String vin) {
        Params request = Params.create()
            .put("vin", vin);
        return client.post("/v1/vin5/query", request, Vin5Result.class);
    }

    /**
     * 车辆五项信息查询。
     *
     * @param carNo 车牌号
     */
    public ApiResponse<CarFiveResult> carFiveQuery(String carNo) {
        Params request = Params.create()
            .put("carNo", carNo);
        return client.post("/v1/car_five/query", request, CarFiveResult.class);
    }

    /**
     * 车品牌查询。
     */
    public ApiResponse<JsonNode> carBrandQuery() {
        Params request = Params.create();
        return client.post("/v1/car_brand/query", request);
    }

    /**
     * 根据品牌查车系。
     *
     * @param brandId 车系 ID
     */
    public ApiResponse<JsonNode> carSeriesQuery(String brandId) {
        Params request = Params.create()
            .put("brandId", brandId);
        return client.post("/v1/car_series/query", request);
    }

    /**
     * 根据车系查车型。
     *
     * @param seriesId 车系 ID
     * @param sort 排序字段，可选（可选）
     */
    public ApiResponse<JsonNode> carTypeQuery(String seriesId, String sort) {
        Params request = Params.create()
            .put("seriesId", seriesId)
            .put("sort", sort);
        return client.post("/v1/car_type/query", request);
    }

    /**
     * 根据车系查车型，只传必填参数。
     *
     * @param seriesId 车系 ID
     */
    public ApiResponse<JsonNode> carTypeQuery(String seriesId) {
        return carTypeQuery(seriesId, null);
    }

    /**
     * 车型配置查询。
     *
     * @param keyword 关键词，企业类接口可用企业名称或统一社会信用代码
     */
    public ApiResponse<JsonNode> carConfigQuery(String keyword) {
        Params request = Params.create()
            .put("keyword", keyword);
        return client.post("/v1/car_config/query", request);
    }

    /**
     * 车型详情查询。
     *
     * @param carid 车型 ID
     */
    public ApiResponse<JsonNode> carDetailQuery(String carid) {
        Params request = Params.create()
            .put("carid", carid);
        return client.post("/v1/car_detail/query", request);
    }

}
