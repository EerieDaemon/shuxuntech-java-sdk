package com.shuxuntech.sdk.model.result;

/** 运营商在网时长。 */
public class MobileOnlineResult {

    /**
     * 1: [0-3)
     * 2: [3-6)
     * 3: [6-12)
     * 4: [12-24)
     * 5: 24 个月及以上
     * 6: 无记录
     * 7: 号码状态异常（1、销号6个月以上 2、携号转网 3、未放号的号码等）
     * 6、7不计费
     */
    private Integer result;

    /** 核验结果描述 */
    private String resultDesc;

    /** 运营商，cmcc、cucc、ctcc */
    private String mobileChannel;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        if (result == null) {
            return;
        }
        this.result = result;
        if (this.resultDesc != null) {
            return;
        }
        if (result == 1) {
            this.resultDesc = "[0-3)";
        } else if (result == 2) {
            this.resultDesc = "[3-6)";
        } else if (result == 3) {
            this.resultDesc = "[6-12)";
        } else if (result == 4) {
            this.resultDesc = "[12-24)";
        } else if (result == 5) {
            this.resultDesc = "24个月及以上";
        } else if (result == 6) {
            this.resultDesc = "无记录";
        } else if (result == 7) {
            this.resultDesc = "号码状态异常";
        }
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getMobileChannel() {
        return mobileChannel;
    }

    public void setMobileChannel(String mobileChannel) {
        this.mobileChannel = mobileChannel;
    }

}
