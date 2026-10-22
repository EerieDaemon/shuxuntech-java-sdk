package com.shuxuntech.sdk.model.result;

/** 企业2要素。 */
public class Enterprise2Result {

    /**
     * 1：一致
     * 2：不一致
     */
    private Integer result;

    /** 核验结果描述 */
    private String resultDesc;

    /**
     * 状态
     * 1:存续; 2:注销; 3:吊销; 4:撤销; 5:迁出; 6:设立中; 7:清算中; 8:停业; 9:其他; 10:空; 11:歇业; 12:责令关闭; 13:已取缔非法社会组织; 14:涉嫌非法社会组织; 15:待注销
     */
    private String status;

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
        } else {
            this.resultDesc = "核验不一致";
        }
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
