package com.shuxuntech.sdk.model.result;

import java.util.List;

/** 企业工商信息返回结果。 */
public class EnterpriseBaseInfoResult {

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

        /** 公司名称 */
        private String companyName;

        /** 统一社会信用代码 */
        private String creditCode;

        /** 组织机构代码 */
        private String orgNumber;

        /** 企业类型 */
        private String companyType;

        /** 企业关键人名称 */
        private String keyPersonName;

        /** 企业关键人类型 */
        private String keyPersonType;

        /** 注册资本(万元) */
        private String regCapital;

        /** 实缴资本 */
        private String actualCapital;

        /** 所属省份 */
        private String province;

        /** 所属省份code */
        private String provinceCode;

        /** 所属城市 */
        private String city;

        /** 所属城市code */
        private String cityCode;

        /** 所属区 */
        private String district;

        /** 所属区code */
        private String districtCode;

        /** 注册号 */
        private String regNumber;

        /** 登记机关 */
        private String authority;

        /** 注册地址 */
        private String regLocation;

        /** 营业状态 */
        private String regStatus;

        /** 经营范围 */
        private String businessScope;

        /** 成立日期 */
        private String establishTime;

        /** 核准日期 */
        private String approvedTime;

        /** 营业期限始 */
        private String termStart;

        /** 营业期限至 */
        private String termEnd;

        /** 更新时间 */
        private String lastUpdatedTime;

        /** 企业历史名称 */
        private String historyNames;

        /** 行业门类 */
        private Industry industry;

        /** 联系方式，地址、电话、邮箱、官网 */
        private Contacts contacts;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
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

        public String getCompanyType() {
            return companyType;
        }

        public void setCompanyType(String companyType) {
            this.companyType = companyType;
        }

        public String getKeyPersonName() {
            return keyPersonName;
        }

        public void setKeyPersonName(String keyPersonName) {
            this.keyPersonName = keyPersonName;
        }

        public String getKeyPersonType() {
            return keyPersonType;
        }

        public void setKeyPersonType(String keyPersonType) {
            this.keyPersonType = keyPersonType;
        }

        public String getRegCapital() {
            return regCapital;
        }

        public void setRegCapital(String regCapital) {
            this.regCapital = regCapital;
        }

        public String getActualCapital() {
            return actualCapital;
        }

        public void setActualCapital(String actualCapital) {
            this.actualCapital = actualCapital;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getProvinceCode() {
            return provinceCode;
        }

        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getDistrictCode() {
            return districtCode;
        }

        public void setDistrictCode(String districtCode) {
            this.districtCode = districtCode;
        }

        public String getRegNumber() {
            return regNumber;
        }

        public void setRegNumber(String regNumber) {
            this.regNumber = regNumber;
        }

        public String getAuthority() {
            return authority;
        }

        public void setAuthority(String authority) {
            this.authority = authority;
        }

        public String getRegLocation() {
            return regLocation;
        }

        public void setRegLocation(String regLocation) {
            this.regLocation = regLocation;
        }

        public String getRegStatus() {
            return regStatus;
        }

        public void setRegStatus(String regStatus) {
            this.regStatus = regStatus;
        }

        public String getBusinessScope() {
            return businessScope;
        }

        public void setBusinessScope(String businessScope) {
            this.businessScope = businessScope;
        }

        public String getEstablishTime() {
            return establishTime;
        }

        public void setEstablishTime(String establishTime) {
            this.establishTime = establishTime;
        }

        public String getApprovedTime() {
            return approvedTime;
        }

        public void setApprovedTime(String approvedTime) {
            this.approvedTime = approvedTime;
        }

        public String getTermStart() {
            return termStart;
        }

        public void setTermStart(String termStart) {
            this.termStart = termStart;
        }

        public String getTermEnd() {
            return termEnd;
        }

        public void setTermEnd(String termEnd) {
            this.termEnd = termEnd;
        }

        public String getLastUpdatedTime() {
            return lastUpdatedTime;
        }

        public void setLastUpdatedTime(String lastUpdatedTime) {
            this.lastUpdatedTime = lastUpdatedTime;
        }

        public String getHistoryNames() {
            return historyNames;
        }

        public void setHistoryNames(String historyNames) {
            this.historyNames = historyNames;
        }

        public Industry getIndustry() {
            return industry;
        }

        public void setIndustry(Industry industry) {
            this.industry = industry;
        }

        public Contacts getContacts() {
            return contacts;
        }

        public void setContacts(Contacts contacts) {
            this.contacts = contacts;
        }

    }
    public static class Industry {

        /** 行业门类描述 */
        private String industry;

        /** 行业门类code */
        private String industryCode;

        /** 行业大类描述 */
        private String subIndustry;

        /** 行业大类code */
        private String subIndustryCode;

        /** 行业中类描述 */
        private String middleCategory;

        /** 行业中类code */
        private String middleCategoryCode;

        /** 行业小类描述 */
        private String smallCategory;

        /** 行业小类code */
        private String smallCategoryCode;

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getIndustryCode() {
            return industryCode;
        }

        public void setIndustryCode(String industryCode) {
            this.industryCode = industryCode;
        }

        public String getSubIndustry() {
            return subIndustry;
        }

        public void setSubIndustry(String subIndustry) {
            this.subIndustry = subIndustry;
        }

        public String getSubIndustryCode() {
            return subIndustryCode;
        }

        public void setSubIndustryCode(String subIndustryCode) {
            this.subIndustryCode = subIndustryCode;
        }

        public String getMiddleCategory() {
            return middleCategory;
        }

        public void setMiddleCategory(String middleCategory) {
            this.middleCategory = middleCategory;
        }

        public String getMiddleCategoryCode() {
            return middleCategoryCode;
        }

        public void setMiddleCategoryCode(String middleCategoryCode) {
            this.middleCategoryCode = middleCategoryCode;
        }

        public String getSmallCategory() {
            return smallCategory;
        }

        public void setSmallCategory(String smallCategory) {
            this.smallCategory = smallCategory;
        }

        public String getSmallCategoryCode() {
            return smallCategoryCode;
        }

        public void setSmallCategoryCode(String smallCategoryCode) {
            this.smallCategoryCode = smallCategoryCode;
        }

    }
    public static class Contacts {

        /** 地址 */
        private List<Note> address;

        /** 电话号码 */
        private List<Note> phoneNumber;

        /** 邮箱 */
        private List<Note> email;

        /** 官网 */
        private List<Note> website;

        public List<Note> getAddress() {
            return address;
        }

        public void setAddress(List<Note> address) {
            this.address = address;
        }

        public List<Note> getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(List<Note> phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public List<Note> getEmail() {
            return email;
        }

        public void setEmail(List<Note> email) {
            this.email = email;
        }

        public List<Note> getWebsite() {
            return website;
        }

        public void setWebsite(List<Note> website) {
            this.website = website;
        }

    }
    public static class Note {

        /** 备注 */
        private String note;

        /** 值 */
        private String value;

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
}
