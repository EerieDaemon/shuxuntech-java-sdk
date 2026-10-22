package com.shuxuntech.sdk.model.result;

/** 运营商在网状态。 */
public class MobileStatusResult {

    /**
     * 1：正常
     * 2：停机
     * 3：在网不可用
     * 4：销号/未启用
     * 5：无记录，不计费
     */
    private Integer result;

    /** 运营商，cmcc、cucc、ctcc */
    private String mobileChannel;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMobileChannel() {
        return mobileChannel;
    }

    public void setMobileChannel(String mobileChannel) {
        this.mobileChannel = mobileChannel;
    }

}
