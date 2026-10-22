package com.shuxuntech.sdk.model.result;

/** 企业对公账户打款验证。 */
public class EntAcctCheckResult {

    /**
     * 1：一致
     * 2：不一致
     */
    private Integer result;

    /** 不一致时返回原因 */
    private String reason;

    /** 打款金额 */
    private Integer amt;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getAmt() {
        return amt;
    }

    public void setAmt(Integer amt) {
        this.amt = amt;
    }

}
