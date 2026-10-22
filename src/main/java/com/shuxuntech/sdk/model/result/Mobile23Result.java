package com.shuxuntech.sdk.model.result;

/** 运营商2、3要素验证返回结果。 */
public class Mobile23Result {

    /**
     * 1：一致
     * 2：不一致
     * 3：无记录，不计费
     */
    private Integer result;

    /** 结果描述 */
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
            this.resultDesc = "核验一致";
        } else if (result == 2) {
            this.resultDesc = "核验不一致";
        } else {
            this.resultDesc = "查询无记录";
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
