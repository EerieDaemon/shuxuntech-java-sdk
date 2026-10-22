package com.shuxuntech.sdk.model.result;

/** 企业四要素。 */
public class Enterprise4Result {

    /**
     * 1：查询成功
     * 2：查询无记录，不计费
     */
    private Integer result;

    private Match match;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public static class Match {

        /**
         * 法人姓名是否一致
         * 1：一致
         * 2：不一致
         */
        private Integer matchFName;

        /**
         * 证件号是否一致，
         * 1：一致
         * 2：不一致
         */
        private Integer matchFIdCard;

        /**
         * 企业名称是否一致
         * 1：一致
         * 2：不一致
         */
        private Integer matchTitle;

        /**
         * 统一信用代码是否一致
         * 1：一致
         * 2：不一致
         */
        private Integer matchCreditCode;

        /**
         * 是否全部匹配
         * 1：一致
         * 2：不一致
         */
        private Integer matchAll;

        public Integer getMatchFName() {
            return matchFName;
        }

        public void setMatchFName(Integer matchFName) {
            this.matchFName = matchFName;
        }

        public Integer getMatchFIdCard() {
            return matchFIdCard;
        }

        public void setMatchFIdCard(Integer matchFIdCard) {
            this.matchFIdCard = matchFIdCard;
        }

        public Integer getMatchTitle() {
            return matchTitle;
        }

        public void setMatchTitle(Integer matchTitle) {
            this.matchTitle = matchTitle;
        }

        public Integer getMatchCreditCode() {
            return matchCreditCode;
        }

        public void setMatchCreditCode(Integer matchCreditCode) {
            this.matchCreditCode = matchCreditCode;
        }

        public Integer getMatchAll() {
            return matchAll;
        }

        public void setMatchAll(Integer matchAll) {
            this.matchAll = matchAll;
        }

    }
}
