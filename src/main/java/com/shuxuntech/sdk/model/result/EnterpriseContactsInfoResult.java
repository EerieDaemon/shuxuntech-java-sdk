package com.shuxuntech.sdk.model.result;

/** 企业联系人信息返回结果。 */
public class EnterpriseContactsInfoResult {

    /**
     * 1:查询成功，有数据
     * 2:查询成功，无数据
     */
    private Integer result;

    /** 查询数据 */
    private Info info;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public static class Info {

        /** 邮箱 */
        private String emails;

        /** 公司 id */
        private String companyId;

        /** 公司名称 */
        private String companyName;

        /** 联系方式 */
        private String phones;

        /** 企业关键人 */
        private String keyPersonName;

        public String getEmails() {
            return emails;
        }

        public void setEmails(String emails) {
            this.emails = emails;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getPhones() {
            return phones;
        }

        public void setPhones(String phones) {
            this.phones = phones;
        }

        public String getKeyPersonName() {
            return keyPersonName;
        }

        public void setKeyPersonName(String keyPersonName) {
            this.keyPersonName = keyPersonName;
        }

    }
}
