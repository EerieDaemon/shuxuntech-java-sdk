package com.shuxuntech.sdk.model.result;

/** 企业3要素。 */
public class Enterprise3Result {

    /**
     * 企业名称是否匹配
     * 1：是
     * 0：否
     */
    private Integer matchEntName;

    /**
     * 统一社会信用代码是否匹配
     * 1：是
     * 0：否
     */
    private Integer matchCreditCode;

    /**
     * 核验人员姓名是否匹配
     * 1：是
     * 0：否
     */
    private Integer matchPersonName;

    /**
     * 核验人员是否法人
     * 1：是
     * 0：否
     */
    private Integer isFr;

    /**
     * 核验人员是否高管
     * 1：是
     * 0：否
     */
    private Integer isManager;

    /**
     * 核验人员是否股东
     * 1：是
     * 0：否
     */
    private Integer isShareholders;

    /**
     * 企业是否在营
     * 1: 是
     * 0: 否
     */
    private Integer entStatus;

    /**
     * 企业类型
     * 1: 企业
     * 0: 个体
     */
    private Integer entType;

    /** 成立日期 */
    private String esDate;

    /** 经营期限从 */
    private String opFrom;

    /** 经营期限至 */
    private String opTo;

    public Integer getMatchEntName() {
        return matchEntName;
    }

    public void setMatchEntName(Integer matchEntName) {
        this.matchEntName = matchEntName;
    }

    public Integer getMatchCreditCode() {
        return matchCreditCode;
    }

    public void setMatchCreditCode(Integer matchCreditCode) {
        this.matchCreditCode = matchCreditCode;
    }

    public Integer getMatchPersonName() {
        return matchPersonName;
    }

    public void setMatchPersonName(Integer matchPersonName) {
        this.matchPersonName = matchPersonName;
    }

    public Integer getIsFr() {
        return isFr;
    }

    public void setIsFr(Integer isFr) {
        this.isFr = isFr;
    }

    public Integer getIsManager() {
        return isManager;
    }

    public void setIsManager(Integer isManager) {
        this.isManager = isManager;
    }

    public Integer getIsShareholders() {
        return isShareholders;
    }

    public void setIsShareholders(Integer isShareholders) {
        this.isShareholders = isShareholders;
    }

    public Integer getEntStatus() {
        return entStatus;
    }

    public void setEntStatus(Integer entStatus) {
        this.entStatus = entStatus;
    }

    public Integer getEntType() {
        return entType;
    }

    public void setEntType(Integer entType) {
        this.entType = entType;
    }

    public String getEsDate() {
        return esDate;
    }

    public void setEsDate(String esDate) {
        this.esDate = esDate;
    }

    public String getOpFrom() {
        return opFrom;
    }

    public void setOpFrom(String opFrom) {
        this.opFrom = opFrom;
    }

    public String getOpTo() {
        return opTo;
    }

    public void setOpTo(String opTo) {
        this.opTo = opTo;
    }

}
