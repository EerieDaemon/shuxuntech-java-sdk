package com.shuxuntech.sdk.model.result;

import java.util.List;

/** 企业名称模糊查询返回结果。 */
public class EnterpriseNameLikeResult {

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

        private String companyStatus;

        private String creditNno;

        private String companyName;

        private String companyCode;

        private List<String> historyName;

        public String getCompanyStatus() {
            return companyStatus;
        }

        public void setCompanyStatus(String companyStatus) {
            this.companyStatus = companyStatus;
        }

        public String getCreditNno() {
            return creditNno;
        }

        public void setCreditNno(String creditNno) {
            this.creditNno = creditNno;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyCode() {
            return companyCode;
        }

        public void setCompanyCode(String companyCode) {
            this.companyCode = companyCode;
        }

        public List<String> getHistoryName() {
            return historyName;
        }

        public void setHistoryName(List<String> historyName) {
            this.historyName = historyName;
        }

    }
}
