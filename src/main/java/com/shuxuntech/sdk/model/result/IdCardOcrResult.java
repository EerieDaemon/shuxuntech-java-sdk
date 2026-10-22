package com.shuxuntech.sdk.model.result;

/** 身份证OCR。 */
public class IdCardOcrResult {

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

        private String side;

        private Integer type;

        private Front front;

        private Back back;

        public String getSide() {
            return side;
        }

        public void setSide(String side) {
            this.side = side;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Front getFront() {
            return front;
        }

        public void setFront(Front front) {
            this.front = front;
        }

        public Back getBack() {
            return back;
        }

        public void setBack(Back back) {
            this.back = back;
        }

    }
    public static class Front {

        private String birthday;

        private String address;

        private String gender;

        private String race;

        private String name;

        private String idCard;

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            this.race = race;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

    }
    public static class Back {

        private String issuedBy;

        private String validDate;

        public String getIssuedBy() {
            return issuedBy;
        }

        public void setIssuedBy(String issuedBy) {
            this.issuedBy = issuedBy;
        }

        public String getValidDate() {
            return validDate;
        }

        public void setValidDate(String validDate) {
            this.validDate = validDate;
        }

    }
}
