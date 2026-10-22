package com.shuxuntech.sdk.model.result;

/** 人脸比对。 */
public class FaceCompareResult {

    /**
     * 1: 比对成功，有数据
     * 2: 比对成功，无数据
     * 3：比对失败，无法正确解析、未按要求传入参数、下载图片超时
     */
    private Integer result;

    /** 识别结果描述 */
    private String resultDesc;

    /** 置信度 */
    private Double confidence;

    /** 置信度阈值 */
    private Threshold threshold;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Threshold getThreshold() {
        return threshold;
    }

    public void setThreshold(Threshold threshold) {
        this.threshold = threshold;
    }

    public static class Threshold {

        private Double threshold1;

        private Double threshold2;

        private Double threshold3;

        public Double getThreshold1() {
            return threshold1;
        }

        public void setThreshold1(Double threshold1) {
            this.threshold1 = threshold1;
        }

        public Double getThreshold2() {
            return threshold2;
        }

        public void setThreshold2(Double threshold2) {
            this.threshold2 = threshold2;
        }

        public Double getThreshold3() {
            return threshold3;
        }

        public void setThreshold3(Double threshold3) {
            this.threshold3 = threshold3;
        }

    }
}
