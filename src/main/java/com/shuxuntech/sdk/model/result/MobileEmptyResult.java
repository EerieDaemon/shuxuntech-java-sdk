package com.shuxuntech.sdk.model.result;

/** 运营商空号检测。 */
public class MobileEmptyResult {

    /**
     * 1：空号
     * 2：实号
     * 3：停机
     * 4：沉默号
     * 5：风险号
     * 6：无记录，不计费
     */
    private Integer result;

    /** 核验结果描述 */
    private String resultDesc;

    /** 运营商，cmcc、cucc、ctcc */
    private String mobileChannel;

    /** 归属地 */
    private String area;

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
            this.resultDesc = "空号";
        } else if (result == 2) {
            this.resultDesc = "实号";
        } else if (result == 3) {
            this.resultDesc = "停机";
        } else if (result == 4) {
            this.resultDesc = "沉默号";
        } else if (result == 5) {
            this.resultDesc = "风险号";
        } else if (result == 6) {
            this.resultDesc = "无记录";
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
