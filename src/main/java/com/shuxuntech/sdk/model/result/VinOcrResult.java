package com.shuxuntech.sdk.model.result;

/** 通用文字OCR。 */
public class VinOcrResult {

    /**
     * 1:识别成功有数据
     * 2:参数错误未识别到数据或不符合车架号规则
     */
    private Integer result;

    private String vin;

    private String brand;

    /** 汽车厂商 */
    private String manufacturer;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
