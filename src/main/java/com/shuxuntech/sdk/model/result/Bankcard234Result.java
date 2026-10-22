package com.shuxuntech.sdk.model.result;

/** 银行卡234简版。 */
public class Bankcard234Result {

    /**
     * 1：一致
     * 2：不一致
     * 3：无效卡号或卡状态异常
     */
    private Integer result;

    /** 核验结果描述 */
    private String resultDesc;

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
            this.resultDesc = "无效卡号或卡状态异常";
        }
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

}
