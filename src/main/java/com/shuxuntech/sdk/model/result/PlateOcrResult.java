package com.shuxuntech.sdk.model.result;

/** 车牌号OCR。 */
public class PlateOcrResult {

    /**
     * 1: 识别成功，有数据
     * 2: 识别成功，无数据
     * 3：识别失败，无法正确解析、未按要求传入参数、下载图片超时
     */
    private Integer result;

    /** 识别结果描述 */
    private String resultDesc;

    private Info info;

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

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public static class Info {

        private String plateNo;

        private String color;

        public String getPlateNo() {
            return plateNo;
        }

        public void setPlateNo(String plateNo) {
            this.plateNo = plateNo;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

    }
}
