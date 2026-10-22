package com.shuxuntech.sdk.model.result;

/** 活体SDK返回结果。 */
public class LivingSdkResult {

    /** 活体检测结果，T、F 或 null */
    private String passed;

    public String getPassed() {
        return passed;
    }

    public void setPassed(String passed) {
        this.passed = passed;
    }

}
