package com.shuxuntech.sdk.model.result;

/** 运营商空号检测优质版。 */
public class MobileEmptyResultV2 {

    /**
     * 1:正常
     * 2：空号
     * 3：关机
     * 4：停机
     * 5：在网但不可用
     * 6：未知，包含以下4种情况，a:特殊号码无法查询 b:号码失败次数超频 c:号码管控 d:号码不存在
     */
    private Integer result;

    /** 核验结果描述 */
    private String resultDesc;

    /** 运营商，cmcc、cucc、ctcc */
    private String mobileChannel;

    /** 归属地 */
    private String area;

    /** 是否携号转网，1：是 0：否 */
    private Integer isTransfer;

    /** 运营商备注 */
    private String remark;

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
            this.resultDesc = "正常";
        } else if (result == 2) {
            this.resultDesc = "空号";
        } else if (result == 3) {
            this.resultDesc = "关机";
        } else if (result == 4) {
            this.resultDesc = "停机";
        } else if (result == 5) {
            this.resultDesc = "在网但不可用";
        } else if (result == 6) {
            this.resultDesc = "未知，a:特殊号码无法查询 b:号码失败次数超频 c:号码管控 d:号码不存在";
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

    public Integer getIsTransfer() {
        return isTransfer;
    }

    public void setIsTransfer(Integer isTransfer) {
        this.isTransfer = isTransfer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
