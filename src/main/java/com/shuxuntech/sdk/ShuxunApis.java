package com.shuxuntech.sdk;

import com.shuxuntech.sdk.api.BankcardApi;
import com.shuxuntech.sdk.api.EnterpriseApi;
import com.shuxuntech.sdk.api.ExpressApi;
import com.shuxuntech.sdk.api.IdentityApi;
import com.shuxuntech.sdk.api.IpApi;
import com.shuxuntech.sdk.api.MobileApi;
import com.shuxuntech.sdk.api.OcrApi;
import com.shuxuntech.sdk.api.VehicleApi;

/**
 * 按业务分类的强类型接口集合。
 *
 * <p>通过 {@link ShuxunClient#apis()} 获取，例如：</p>
 * <pre>{@code
 * ApiResponse<IdCardCheckResult> response = client.apis().identity().idCardCheck("张三", "110101...");
 * }</pre>
 */
public final class ShuxunApis {

    private final IdentityApi identity;
    private final MobileApi mobile;
    private final BankcardApi bankcard;
    private final OcrApi ocr;
    private final EnterpriseApi enterprise;
    private final VehicleApi vehicle;
    private final ExpressApi express;
    private final IpApi ip;

    ShuxunApis(ShuxunClient client) {
        this.identity = new IdentityApi(client);
        this.mobile = new MobileApi(client);
        this.bankcard = new BankcardApi(client);
        this.ocr = new OcrApi(client);
        this.enterprise = new EnterpriseApi(client);
        this.vehicle = new VehicleApi(client);
        this.express = new ExpressApi(client);
        this.ip = new IpApi(client);
    }

    /**
     * 身份核验接口。
     */
    public IdentityApi identity() {
        return identity;
    }

    /**
     * 运营商接口。
     */
    public MobileApi mobile() {
        return mobile;
    }

    /**
     * 银行卡接口。
     */
    public BankcardApi bankcard() {
        return bankcard;
    }

    /**
     * 文字识别接口。
     */
    public OcrApi ocr() {
        return ocr;
    }

    /**
     * 企业服务接口。
     */
    public EnterpriseApi enterprise() {
        return enterprise;
    }

    /**
     * 交通出行接口。
     */
    public VehicleApi vehicle() {
        return vehicle;
    }

    /**
     * 生活服务接口。
     */
    public ExpressApi express() {
        return express;
    }

    /**
     * IP 归属地接口。
     */
    public IpApi ip() {
        return ip;
    }
}
