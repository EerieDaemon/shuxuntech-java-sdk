package com.shuxuntech.sdk.model.result;

import java.util.List;

/** 企业工商信息模糊查询返回结果。 */
public class EnterpriseLikeResult {

    /** 查询总条数 */
    private Integer total;

    /** 查询数据 */
    private List<Item> items;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item {

        private String regStatus1;

        private String regStatus2;

        private String establishTime;

        private String regCapital;

        private String companyType;

        private String companyName;

        private Integer type;

        private String legalPersonName;

        private String regNumber;

        private String creditCode;

        private String orgNumber;

        private String province;

        public String getRegStatus1() {
            return regStatus1;
        }

        public void setRegStatus1(String regStatus1) {
            this.regStatus1 = regStatus1;
        }

        public String getRegStatus2() {
            return regStatus2;
        }

        public void setRegStatus2(String regStatus2) {
            this.regStatus2 = regStatus2;
        }

        public String getEstablishTime() {
            return establishTime;
        }

        public void setEstablishTime(String establishTime) {
            this.establishTime = establishTime;
        }

        public String getRegCapital() {
            return regCapital;
        }

        public void setRegCapital(String regCapital) {
            this.regCapital = regCapital;
        }

        public String getCompanyType() {
            return companyType;
        }

        public void setCompanyType(String companyType) {
            this.companyType = companyType;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getLegalPersonName() {
            return legalPersonName;
        }

        public void setLegalPersonName(String legalPersonName) {
            this.legalPersonName = legalPersonName;
        }

        public String getRegNumber() {
            return regNumber;
        }

        public void setRegNumber(String regNumber) {
            this.regNumber = regNumber;
        }

        public String getCreditCode() {
            return creditCode;
        }

        public void setCreditCode(String creditCode) {
            this.creditCode = creditCode;
        }

        public String getOrgNumber() {
            return orgNumber;
        }

        public void setOrgNumber(String orgNumber) {
            this.orgNumber = orgNumber;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

    }
}
