package com.shuxuntech.sdk.model.result;

/** 银行卡OCR。 */
public class BankcardOcrResult {

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

        private String bankcard;

        private String bank;

        public String getBankcard() {
            return bankcard;
        }

        public void setBankcard(String bankcard) {
            this.bankcard = bankcard;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

    }
}
