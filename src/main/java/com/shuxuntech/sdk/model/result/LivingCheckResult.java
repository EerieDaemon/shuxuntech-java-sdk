package com.shuxuntech.sdk.model.result;

import java.util.List;

/** 图片活体返回结果。 */
public class LivingCheckResult {

    /** 活体检测最高分 */
    private Double maxScore;

    /** 是否是活体，1：是活体；0：不是活体 */
    private Integer isLiving;

    /** 每张图片的检测情况 */
    private List<Face> faces;

    public Double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getIsLiving() {
        return isLiving;
    }

    public void setIsLiving(Integer isLiving) {
        this.isLiving = isLiving;
    }

    public List<Face> getFaces() {
        return faces;
    }

    public void setFaces(List<Face> faces) {
        this.faces = faces;
    }

    public static class Face {

        /** 活体检测分数 */
        private Double score;

        /** 合成图打分，判断图片是否为合成图 */
        private Double spoofing;

        /**
         * 是否带眼睛
         * none:无眼镜，common:普通眼镜，sun:墨镜
         */
        private String glasses;

        /**
         * 性别
         * male:男性 female:女性
         */
        private String gender;

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }

        public Double getSpoofing() {
            return spoofing;
        }

        public void setSpoofing(Double spoofing) {
            this.spoofing = spoofing;
        }

        public String getGlasses() {
            return glasses;
        }

        public void setGlasses(String glasses) {
            this.glasses = glasses;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

    }
}
