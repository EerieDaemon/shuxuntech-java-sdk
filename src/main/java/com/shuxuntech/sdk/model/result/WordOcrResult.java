package com.shuxuntech.sdk.model.result;

import java.util.List;

/** 通用文字OCR。 */
public class WordOcrResult {

    /**
     * 1:识别成功有数据
     * 2:参数错误未识别到数据
     */
    private Integer result;

    private List<TextInfo> text_info;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public List<TextInfo> getText_info() {
        return text_info;
    }

    public void setText_info(List<TextInfo> text_info) {
        this.text_info = text_info;
    }

    public static class TextInfo {

        private Integer line_no;

        private Float confidence;

        private String line_content;

        private LinePosition line_position;

        public Integer getLine_no() {
            return line_no;
        }

        public void setLine_no(Integer line_no) {
            this.line_no = line_no;
        }

        public Float getConfidence() {
            return confidence;
        }

        public void setConfidence(Float confidence) {
            this.confidence = confidence;
        }

        public String getLine_content() {
            return line_content;
        }

        public void setLine_content(String line_content) {
            this.line_content = line_content;
        }

        public LinePosition getLine_position() {
            return line_position;
        }

        public void setLine_position(LinePosition line_position) {
            this.line_position = line_position;
        }

        public static class LinePosition {

            private Integer x;

            private Integer width;

            private Integer y;

            private Integer height;

            private Integer line_direction;

            public Integer getX() {
                return x;
            }

            public void setX(Integer x) {
                this.x = x;
            }

            public Integer getWidth() {
                return width;
            }

            public void setWidth(Integer width) {
                this.width = width;
            }

            public Integer getY() {
                return y;
            }

            public void setY(Integer y) {
                this.y = y;
            }

            public Integer getHeight() {
                return height;
            }

            public void setHeight(Integer height) {
                this.height = height;
            }

            public Integer getLine_direction() {
                return line_direction;
            }

            public void setLine_direction(Integer line_direction) {
                this.line_direction = line_direction;
            }

        }
    }
}
