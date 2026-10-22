package com.shuxuntech.sdk.api;

import com.shuxuntech.sdk.ShuxunClient;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.Params;
import com.shuxuntech.sdk.model.result.IpQueryCityResult;

/**
 * IP 归属地接口。
 *
 * <p>通过 {@link com.shuxuntech.sdk.ShuxunClient#apis()} 获取实例。</p>
 */
public final class IpApi {

    private final ShuxunClient client;

    public IpApi(ShuxunClient client) {
        this.client = client;
    }

    /**
     * IPv4 归属地查询。
     *
     * @param ip 调用方 IP
     */
    public ApiResponse<IpQueryCityResult> ipQuery(String ip) {
        Params request = Params.create()
            .put("ip", ip);
        return client.post("/v1/ip_location/query", request, IpQueryCityResult.class);
    }

    /**
     * IPv6 归属地查询。
     *
     * @param ip 调用方 IP
     */
    public ApiResponse<IpQueryCityResult> ipv6Query(String ip) {
        Params request = Params.create()
            .put("ip", ip);
        return client.post("/v1/ip_location/query/ipv6", request, IpQueryCityResult.class);
    }

}
