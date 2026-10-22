package com.shuxuntech.sdk.model.result;

/** 人脸身份证比对结果。 */
public class FaceIdCardResult extends IdCardCommonResult {

    /**
     * 1: 身份证号与姓名匹配，照片系统判断为同一人
     * 2: 身份证号与姓名匹配，照片不能确定是否为同一人
     * 3: 身份证号与姓名匹配，照片系统判断为不同人
     * 4: 身份证号与姓名不匹配
     * 5: 身份证号与姓名匹配，库中无照片
     * 6: 身份证号与姓名匹配，照片检测失败
     * 7: 库中无此号
     * 8: 照片质量不合格
     */
    private Integer result;

    /**
     * 一所分值区间
     * [0，600）系统判断为不同人；
     * [600，700）不能确定是否为同一人；
     * [700，1000]系统判断为同一人；
     */
    private double hackScore;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public double getHackScore() {
        return hackScore;
    }

    public void setHackScore(double hackScore) {
        this.hackScore = hackScore;
    }

}
