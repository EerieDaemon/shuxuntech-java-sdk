package com.shuxuntech.sdk.model.result;

import java.util.List;

/** 企业工商年报信息返回结果。 */
public class EnterpriseReportResult {

    private Integer total;

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

        private List<StockChang> stockChangList;

        private List<InvestInfo> investInfoList;

        private List<Partner> partnerList;

        private String year;

        private List<ProvideAssurance> provideAssuranceList;

        private Boolean hasDetailInfo;

        private List<Change> changeList;

        private String publishDate;

        private List<AssetsData> assetsData;

        private List<WebSite> webSiteList;

        private List<SocialSecurity> socialSecurity;

        private BasicInfoData basicInfoData;

        public List<StockChang> getStockChangList() {
            return stockChangList;
        }

        public void setStockChangList(List<StockChang> stockChangList) {
            this.stockChangList = stockChangList;
        }

        public List<InvestInfo> getInvestInfoList() {
            return investInfoList;
        }

        public void setInvestInfoList(List<InvestInfo> investInfoList) {
            this.investInfoList = investInfoList;
        }

        public List<Partner> getPartnerList() {
            return partnerList;
        }

        public void setPartnerList(List<Partner> partnerList) {
            this.partnerList = partnerList;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public List<ProvideAssurance> getProvideAssuranceList() {
            return provideAssuranceList;
        }

        public void setProvideAssuranceList(List<ProvideAssurance> provideAssuranceList) {
            this.provideAssuranceList = provideAssuranceList;
        }

        public Boolean getHasDetailInfo() {
            return hasDetailInfo;
        }

        public void setHasDetailInfo(Boolean hasDetailInfo) {
            this.hasDetailInfo = hasDetailInfo;
        }

        public List<Change> getChangeList() {
            return changeList;
        }

        public void setChangeList(List<Change> changeList) {
            this.changeList = changeList;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public List<AssetsData> getAssetsData() {
            return assetsData;
        }

        public void setAssetsData(List<AssetsData> assetsData) {
            this.assetsData = assetsData;
        }

        public List<WebSite> getWebSiteList() {
            return webSiteList;
        }

        public void setWebSiteList(List<WebSite> webSiteList) {
            this.webSiteList = webSiteList;
        }

        public List<SocialSecurity> getSocialSecurity() {
            return socialSecurity;
        }

        public void setSocialSecurity(List<SocialSecurity> socialSecurity) {
            this.socialSecurity = socialSecurity;
        }

        public BasicInfoData getBasicInfoData() {
            return basicInfoData;
        }

        public void setBasicInfoData(BasicInfoData basicInfoData) {
            this.basicInfoData = basicInfoData;
        }

    }
    public static class StockChang {

        private String before;

        private String changeDate;

        private String name;

        private String after;

        public String getBefore() {
            return before;
        }

        public void setBefore(String before) {
            this.before = before;
        }

        public String getChangeDate() {
            return changeDate;
        }

        public void setChangeDate(String changeDate) {
            this.changeDate = changeDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAfter() {
            return after;
        }

        public void setAfter(String after) {
            this.after = after;
        }

    }
    public static class InvestInfo {

        private String regNo;

        private String creditCode;

        private String name;

        public String getRegNo() {
            return regNo;
        }

        public void setRegNo(String regNo) {
            this.regNo = regNo;
        }

        public String getCreditCode() {
            return creditCode;
        }

        public void setCreditCode(String creditCode) {
            this.creditCode = creditCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
    public static class Partner {

        private String shouldDate;

        private String realType;

        private String shouldType;

        private String realCapi;

        private String name;

        private String shouldCapi;

        private String realDate;

        public String getShouldDate() {
            return shouldDate;
        }

        public void setShouldDate(String shouldDate) {
            this.shouldDate = shouldDate;
        }

        public String getRealType() {
            return realType;
        }

        public void setRealType(String realType) {
            this.realType = realType;
        }

        public String getShouldType() {
            return shouldType;
        }

        public void setShouldType(String shouldType) {
            this.shouldType = shouldType;
        }

        public String getRealCapi() {
            return realCapi;
        }

        public void setRealCapi(String realCapi) {
            this.realCapi = realCapi;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShouldCapi() {
            return shouldCapi;
        }

        public void setShouldCapi(String shouldCapi) {
            this.shouldCapi = shouldCapi;
        }

        public String getRealDate() {
            return realDate;
        }

        public void setRealDate(String realDate) {
            this.realDate = realDate;
        }

    }
    public static class ProvideAssurance {

        private String assuranceDurn;

        private String assuranceType;

        private String assuranceScope;

        private String creditor;

        private String debtor;

        private String creditorCategory;

        private String creditorAmount;

        private String fulfillObligation;

        public String getAssuranceDurn() {
            return assuranceDurn;
        }

        public void setAssuranceDurn(String assuranceDurn) {
            this.assuranceDurn = assuranceDurn;
        }

        public String getAssuranceType() {
            return assuranceType;
        }

        public void setAssuranceType(String assuranceType) {
            this.assuranceType = assuranceType;
        }

        public String getAssuranceScope() {
            return assuranceScope;
        }

        public void setAssuranceScope(String assuranceScope) {
            this.assuranceScope = assuranceScope;
        }

        public String getCreditor() {
            return creditor;
        }

        public void setCreditor(String creditor) {
            this.creditor = creditor;
        }

        public String getDebtor() {
            return debtor;
        }

        public void setDebtor(String debtor) {
            this.debtor = debtor;
        }

        public String getCreditorCategory() {
            return creditorCategory;
        }

        public void setCreditorCategory(String creditorCategory) {
            this.creditorCategory = creditorCategory;
        }

        public String getCreditorAmount() {
            return creditorAmount;
        }

        public void setCreditorAmount(String creditorAmount) {
            this.creditorAmount = creditorAmount;
        }

        public String getFulfillObligation() {
            return fulfillObligation;
        }

        public void setFulfillObligation(String fulfillObligation) {
            this.fulfillObligation = fulfillObligation;
        }

    }
    public static class Change {

        private String changeName;

        private String before;

        private String after;

        private String changeDate;

        public String getChangeName() {
            return changeName;
        }

        public void setChangeName(String changeName) {
            this.changeName = changeName;
        }

        public String getBefore() {
            return before;
        }

        public void setBefore(String before) {
            this.before = before;
        }

        public String getAfter() {
            return after;
        }

        public void setAfter(String after) {
            this.after = after;
        }

        public String getChangeDate() {
            return changeDate;
        }

        public void setChangeDate(String changeDate) {
            this.changeDate = changeDate;
        }

    }
    public static class AssetsData {

        private String bankingCredit;

        private String mainBusinessIncome;

        private String governmentSubsidy;

        private String totalProfit;

        private String totalAssets;

        private String totalLiabilities;

        private String totalOwnersEquity;

        private String grossTradingIncome;

        private String totalTaxAmount;

        private String netProfit;

        public String getBankingCredit() {
            return bankingCredit;
        }

        public void setBankingCredit(String bankingCredit) {
            this.bankingCredit = bankingCredit;
        }

        public String getMainBusinessIncome() {
            return mainBusinessIncome;
        }

        public void setMainBusinessIncome(String mainBusinessIncome) {
            this.mainBusinessIncome = mainBusinessIncome;
        }

        public String getGovernmentSubsidy() {
            return governmentSubsidy;
        }

        public void setGovernmentSubsidy(String governmentSubsidy) {
            this.governmentSubsidy = governmentSubsidy;
        }

        public String getTotalProfit() {
            return totalProfit;
        }

        public void setTotalProfit(String totalProfit) {
            this.totalProfit = totalProfit;
        }

        public String getTotalAssets() {
            return totalAssets;
        }

        public void setTotalAssets(String totalAssets) {
            this.totalAssets = totalAssets;
        }

        public String getTotalLiabilities() {
            return totalLiabilities;
        }

        public void setTotalLiabilities(String totalLiabilities) {
            this.totalLiabilities = totalLiabilities;
        }

        public String getTotalOwnersEquity() {
            return totalOwnersEquity;
        }

        public void setTotalOwnersEquity(String totalOwnersEquity) {
            this.totalOwnersEquity = totalOwnersEquity;
        }

        public String getGrossTradingIncome() {
            return grossTradingIncome;
        }

        public void setGrossTradingIncome(String grossTradingIncome) {
            this.grossTradingIncome = grossTradingIncome;
        }

        public String getTotalTaxAmount() {
            return totalTaxAmount;
        }

        public void setTotalTaxAmount(String totalTaxAmount) {
            this.totalTaxAmount = totalTaxAmount;
        }

        public String getNetProfit() {
            return netProfit;
        }

        public void setNetProfit(String netProfit) {
            this.netProfit = netProfit;
        }

    }
    public static class WebSite {

        private String webSite;

        private String name;

        private String type;

        public String getWebSite() {
            return webSite;
        }

        public void setWebSite(String webSite) {
            this.webSite = webSite;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }
    public static class SocialSecurity {

        private String insuranceAmount;

        private String insuranceRealCapital;

        private String insuranceName;

        private String insuranceBase;

        private String insuranceArrearage;

        public String getInsuranceAmount() {
            return insuranceAmount;
        }

        public void setInsuranceAmount(String insuranceAmount) {
            this.insuranceAmount = insuranceAmount;
        }

        public String getInsuranceRealCapital() {
            return insuranceRealCapital;
        }

        public void setInsuranceRealCapital(String insuranceRealCapital) {
            this.insuranceRealCapital = insuranceRealCapital;
        }

        public String getInsuranceName() {
            return insuranceName;
        }

        public void setInsuranceName(String insuranceName) {
            this.insuranceName = insuranceName;
        }

        public String getInsuranceBase() {
            return insuranceBase;
        }

        public void setInsuranceBase(String insuranceBase) {
            this.insuranceBase = insuranceBase;
        }

        public String getInsuranceArrearage() {
            return insuranceArrearage;
        }

        public void setInsuranceArrearage(String insuranceArrearage) {
            this.insuranceArrearage = insuranceArrearage;
        }

    }
    public static class BasicInfoData {

        private String regNo;

        private String address;

        private String hasProvideAssurance;

        private String operationDuration;

        private String companyName;

        private String mainType;

        private String operatorName;

        private String employeeCount;

        private String hasWebSite;

        private String emailAddress;

        private String belongTo;

        private String postCode;

        private String hasNewStockOrByStock;

        private String isStockRightTransfer;

        private String capitalAmount;

        private String contactNo;

        private String status;

        private String operationPlaces;

        public String getRegNo() {
            return regNo;
        }

        public void setRegNo(String regNo) {
            this.regNo = regNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getHasProvideAssurance() {
            return hasProvideAssurance;
        }

        public void setHasProvideAssurance(String hasProvideAssurance) {
            this.hasProvideAssurance = hasProvideAssurance;
        }

        public String getOperationDuration() {
            return operationDuration;
        }

        public void setOperationDuration(String operationDuration) {
            this.operationDuration = operationDuration;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getMainType() {
            return mainType;
        }

        public void setMainType(String mainType) {
            this.mainType = mainType;
        }

        public String getOperatorName() {
            return operatorName;
        }

        public void setOperatorName(String operatorName) {
            this.operatorName = operatorName;
        }

        public String getEmployeeCount() {
            return employeeCount;
        }

        public void setEmployeeCount(String employeeCount) {
            this.employeeCount = employeeCount;
        }

        public String getHasWebSite() {
            return hasWebSite;
        }

        public void setHasWebSite(String hasWebSite) {
            this.hasWebSite = hasWebSite;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getBelongTo() {
            return belongTo;
        }

        public void setBelongTo(String belongTo) {
            this.belongTo = belongTo;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public String getHasNewStockOrByStock() {
            return hasNewStockOrByStock;
        }

        public void setHasNewStockOrByStock(String hasNewStockOrByStock) {
            this.hasNewStockOrByStock = hasNewStockOrByStock;
        }

        public String getIsStockRightTransfer() {
            return isStockRightTransfer;
        }

        public void setIsStockRightTransfer(String isStockRightTransfer) {
            this.isStockRightTransfer = isStockRightTransfer;
        }

        public String getCapitalAmount() {
            return capitalAmount;
        }

        public void setCapitalAmount(String capitalAmount) {
            this.capitalAmount = capitalAmount;
        }

        public String getContactNo() {
            return contactNo;
        }

        public void setContactNo(String contactNo) {
            this.contactNo = contactNo;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getOperationPlaces() {
            return operationPlaces;
        }

        public void setOperationPlaces(String operationPlaces) {
            this.operationPlaces = operationPlaces;
        }

    }
}
