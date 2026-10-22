package com.shuxuntech.sdk.model.result;

/** 银行卡归属地信息。 */
public class BankPlaceResult {

    /**
     * 1：查询成功，计费
     * 2：不符合Luhn / 不符合卡BIN
     * 3：查无信息（该卡号暂未收录）
     */
    private Integer result;

    /** 归属地信息 */
    private PlaceInfo placeInfo;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public PlaceInfo getPlaceInfo() {
        return placeInfo;
    }

    public void setPlaceInfo(PlaceInfo placeInfo) {
        this.placeInfo = placeInfo;
    }

    public static class PlaceInfo {

        private Integer binDigits;

        private String bank;

        private String cardBin;

        private String province;

        private String cardName;

        private String city;

        private String tel;

        private String bankLogo;

        private String type;

        private Integer cardDigits;

        private Boolean luhn;

        private String card;

        public Integer getBinDigits() {
            return binDigits;
        }

        public void setBinDigits(Integer binDigits) {
            this.binDigits = binDigits;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getCardBin() {
            return cardBin;
        }

        public void setCardBin(String cardBin) {
            this.cardBin = cardBin;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getBankLogo() {
            return bankLogo;
        }

        public void setBankLogo(String bankLogo) {
            this.bankLogo = bankLogo;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getCardDigits() {
            return cardDigits;
        }

        public void setCardDigits(Integer cardDigits) {
            this.cardDigits = cardDigits;
        }

        public Boolean getLuhn() {
            return luhn;
        }

        public void setLuhn(Boolean luhn) {
            this.luhn = luhn;
        }

        public String getCard() {
            return card;
        }

        public void setCard(String card) {
            this.card = card;
        }

    }
}
