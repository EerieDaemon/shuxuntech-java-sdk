package com.shuxuntech.sdk.model.result;

/** 运营商空号检测。 */
public class SmsSendResult {

    /** 上游批次号 */
    private String taskId;

    /** 成功条数 */
    private Integer successNum;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

}
