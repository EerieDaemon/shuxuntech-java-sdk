package com.shuxuntech.sdk.model.result;

/** 运营商携号转网。 */
public class MobileTransformResult {

    /**
     * 1：转网
     * 2：未转网
     */
    private Integer result;

    /** 核验结果描述 */
    private String resultDesc;

    /** 新运营商 */
    private String newChannel;

    /** 原运营商 */
    private String oldChannel;

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
            this.resultDesc = "转网号码";
        } else {
            this.resultDesc = "未转网";
        }
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getNewChannel() {
        return newChannel;
    }

    public void setNewChannel(String newChannel) {
        this.newChannel = newChannel;
    }

    public String getOldChannel() {
        return oldChannel;
    }

    public void setOldChannel(String oldChannel) {
        this.oldChannel = oldChannel;
    }

}
