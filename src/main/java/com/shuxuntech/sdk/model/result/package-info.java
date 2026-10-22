/**
 * 平台各接口的响应模型（统一响应中的 {@code data} 字段）。
 *
 * <p>字段与 sx-data 项目 {@code com.shuxun.data.api.result} 下的返回类保持一致，
 * 可直接配合 {@link com.shuxuntech.sdk.model.ApiResponse} 使用：</p>
 *
 * <pre>{@code
 * ApiResponse<IdCardCheckResult> response = client.post(
 *         "/v1/idCard/check", params, IdCardCheckResult.class);
 * }</pre>
 */
package com.shuxuntech.sdk.model.result;
