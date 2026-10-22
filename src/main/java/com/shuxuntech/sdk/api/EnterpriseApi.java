package com.shuxuntech.sdk.api;

import com.shuxuntech.sdk.ShuxunClient;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.Params;
import com.shuxuntech.sdk.model.result.Enterprise2Result;
import com.shuxuntech.sdk.model.result.Enterprise3Result;
import com.shuxuntech.sdk.model.result.Enterprise4Result;
import com.shuxuntech.sdk.model.result.EnterpriseBaseInfoResult;
import com.shuxuntech.sdk.model.result.EnterpriseContactsInfoResult;
import com.shuxuntech.sdk.model.result.EnterpriseReportResult;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 企业服务接口。
 *
 * <p>通过 {@link com.shuxuntech.sdk.ShuxunClient#apis()} 获取实例。</p>
 */
public final class EnterpriseApi {

    private final ShuxunClient client;

    public EnterpriseApi(ShuxunClient client) {
        this.client = client;
    }

    /**
     * 企业二要素核验。
     *
     * @param title 企业名称
     * @param creditCode 统一社会信用代码
     */
    public ApiResponse<Enterprise2Result> enterprise2Check(String title, String creditCode) {
        Params request = Params.create()
            .put("title", title)
            .put("creditCode", creditCode);
        return client.post("/v1/enterprise2/check", request, Enterprise2Result.class);
    }

    /**
     * 企业三要素核验。
     *
     * @param entName 企业名称
     * @param creditCode 统一社会信用代码
     * @param personName 法人/股东姓名
     */
    public ApiResponse<Enterprise3Result> enterprise3Check(String entName, String creditCode, String personName) {
        Params request = Params.create()
            .put("entName", entName)
            .put("creditCode", creditCode)
            .put("personName", personName);
        return client.post("/v1/enterprise3/check", request, Enterprise3Result.class);
    }

    /**
     * 企业四要素核验。
     *
     * @param fName 法人姓名
     * @param fIdCard 法人身份证号
     * @param title 企业名称
     * @param creditCode 统一社会信用代码
     */
    public ApiResponse<Enterprise4Result> enterprise4Check(
            String fName,
            String fIdCard,
            String title,
            String creditCode) {
        Params request = Params.create()
            .put("fName", fName)
            .put("fIdCard", fIdCard)
            .put("title", title)
            .put("creditCode", creditCode);
        return client.post("/v1/enterprise4/check", request, Enterprise4Result.class);
    }

    /**
     * 企业工商信息查询。
     *
     * @param keyword 关键词，企业类接口可用企业名称或统一社会信用代码
     */
    public ApiResponse<EnterpriseBaseInfoResult> enterpriseBaseInfoQuery(String keyword) {
        Params request = Params.create()
            .put("keyword", keyword);
        return client.post("/v1/enterprise_base_info/query", request, EnterpriseBaseInfoResult.class);
    }

    /**
     * 企业联系人信息查询。
     *
     * @param keyword 关键词，企业类接口可用企业名称或统一社会信用代码
     */
    public ApiResponse<EnterpriseContactsInfoResult> enterpriseContactsQuery(String keyword) {
        Params request = Params.create()
            .put("keyword", keyword);
        return client.post("/v1/enterprise_contacts_info/query", request, EnterpriseContactsInfoResult.class);
    }

    /**
     * 企业工商信息模糊查询（分页）。
     *
     * @param keyword 关键词，企业类接口可用企业名称或统一社会信用代码
     * @param pageNo 页码，默认 1（可选）
     * @param pageSize 每页条数，默认 10（可选）
     */
    public ApiResponse<EnterpriseBaseInfoResult> enterpriseLikeQuery(
            String keyword,
            String pageNo,
            String pageSize) {
        Params request = Params.create()
            .put("keyword", keyword)
            .put("pageNo", pageNo)
            .put("pageSize", pageSize);
        return client.post("/v1/enterprise_like/query", request, EnterpriseBaseInfoResult.class);
    }

    /**
     * 企业工商信息模糊查询（分页），只传必填参数。
     *
     * @param keyword 关键词，企业类接口可用企业名称或统一社会信用代码
     */
    public ApiResponse<EnterpriseBaseInfoResult> enterpriseLikeQuery(String keyword) {
        return enterpriseLikeQuery(keyword, null, null);
    }

    /**
     * 企业名称模糊查询。
     *
     * @param keyword 关键词，企业类接口可用企业名称或统一社会信用代码
     * @param pageSize 每页条数，默认 10（可选）
     * @param limit 返回条数上限（可选）
     */
    public ApiResponse<EnterpriseBaseInfoResult> enterpriseNameLikeQuery(
            String keyword,
            String pageSize,
            Integer limit) {
        Params request = Params.create()
            .put("keyword", keyword)
            .put("pageSize", pageSize)
            .put("limit", limit);
        return client.post("/v1/enterprise_name_like/query", request, EnterpriseBaseInfoResult.class);
    }

    /**
     * 企业名称模糊查询，只传必填参数。
     *
     * @param keyword 关键词，企业类接口可用企业名称或统一社会信用代码
     */
    public ApiResponse<EnterpriseBaseInfoResult> enterpriseNameLikeQuery(String keyword) {
        return enterpriseNameLikeQuery(keyword, null, null);
    }

    /**
     * 企业报告查询。
     *
     * @param keyword 关键词，企业类接口可用企业名称或统一社会信用代码
     */
    public ApiResponse<EnterpriseReportResult> enterpriseReportQuery(String keyword) {
        Params request = Params.create()
            .put("keyword", keyword);
        return client.post("/v1/enterprise_report/query", request, EnterpriseReportResult.class);
    }

    /**
     * 企业经营异常查询。
     *
     * @param keyword 关键词，企业类接口可用企业名称或统一社会信用代码
     */
    public ApiResponse<JsonNode> entAbnormalQuery(String keyword) {
        Params request = Params.create()
            .put("keyword", keyword);
        return client.post("/v1/ent_abnormal/query", request);
    }

}
