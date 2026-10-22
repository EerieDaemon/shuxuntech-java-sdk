package com.shuxuntech.sdk.model.result;

/** 营业执照OCR。 */
public class BusinessOcrResult {

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

        private String enterpriseType;

        private String address;

        private String registrationCapital;

        private String opTo;

        private String orgForm;

        private String opScope;

        private String establishingDate;

        private String legalName;

        private String registrationCode;

        private String opFrom;

        private String creditCode;

        private String opPeriod;

        private String enterpriseName;

        private Integer isCopy;

        public String getEnterpriseType() {
            return enterpriseType;
        }

        public void setEnterpriseType(String enterpriseType) {
            this.enterpriseType = enterpriseType;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRegistrationCapital() {
            return registrationCapital;
        }

        public void setRegistrationCapital(String registrationCapital) {
            this.registrationCapital = registrationCapital;
        }

        public String getOpTo() {
            return opTo;
        }

        public void setOpTo(String opTo) {
            this.opTo = opTo;
        }

        public String getOrgForm() {
            return orgForm;
        }

        public void setOrgForm(String orgForm) {
            this.orgForm = orgForm;
        }

        public String getOpScope() {
            return opScope;
        }

        public void setOpScope(String opScope) {
            this.opScope = opScope;
        }

        public String getEstablishingDate() {
            return establishingDate;
        }

        public void setEstablishingDate(String establishingDate) {
            this.establishingDate = establishingDate;
        }

        public String getLegalName() {
            return legalName;
        }

        public void setLegalName(String legalName) {
            this.legalName = legalName;
        }

        public String getRegistrationCode() {
            return registrationCode;
        }

        public void setRegistrationCode(String registrationCode) {
            this.registrationCode = registrationCode;
        }

        public String getOpFrom() {
            return opFrom;
        }

        public void setOpFrom(String opFrom) {
            this.opFrom = opFrom;
        }

        public String getCreditCode() {
            return creditCode;
        }

        public void setCreditCode(String creditCode) {
            this.creditCode = creditCode;
        }

        public String getOpPeriod() {
            return opPeriod;
        }

        public void setOpPeriod(String opPeriod) {
            this.opPeriod = opPeriod;
        }

        public String getEnterpriseName() {
            return enterpriseName;
        }

        public void setEnterpriseName(String enterpriseName) {
            this.enterpriseName = enterpriseName;
        }

        public Integer getIsCopy() {
            return isCopy;
        }

        public void setIsCopy(Integer isCopy) {
            this.isCopy = isCopy;
        }

    }
}
