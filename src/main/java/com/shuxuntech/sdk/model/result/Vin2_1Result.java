package com.shuxuntech.sdk.model.result;

import java.util.List;

/** VIN车架号查询精准优质版返回结果。 */
public class Vin2_1Result {

    /** 品牌名称 */
    private String brand;

    /** 车系名称 */
    private String series;

    /** 车型名称 */
    private String modelName;

    /** 年款 */
    private String years;

    /** 厂商指导价 */
    private String price;

    /** 上市时间 */
    private String timeToMarket;

    /** 厂商 */
    private String factory;

    /** 车辆等级 */
    private String level;

    /** 销售状态 */
    private String salesStatus;

    /** 车身结构 */
    private String body;

    /** 长*宽*高 */
    private String modelSize;

    /** 整备质量 */
    private String curbWeight;

    /** 车门 */
    private String door;

    /** 座位数 */
    private String seat;

    /** 排量 */
    private String displacement;

    /** 档位数 */
    private String shiftNum;

    /** 发动机型号 */
    private String engineCode;

    /** 排量(L/T) */
    private String engine;

    /** 发动机描述 */
    private String engineDesc;

    /** 最大功率 */
    private String maxPower;

    /** 前制动器类型 */
    private String frontBrake;

    /** 后制动器类型 */
    private String rearBrake;

    /** 助力类型 */
    private String assistType;

    /** 轴距 */
    private String wheelBase;

    /** 前轮距 */
    private String wheelBaseFont;

    /** 后轮距 */
    private String wheelBaseRear;

    /** 前轮胎规格 */
    private String frontTire;

    /** 后轮胎规格 */
    private String rearTire;

    /** 备胎规格 */
    private String spareTire;

    /** 驱动方式 */
    private String driverType;

    /** 变速箱类型 */
    private String transType;

    /** 变速箱描述 */
    private String transDes;

    /** 进气形式 */
    private String engineGasIn;

    /** 每缸气门数(个) */
    private String engineGasinNumber;

    /** 气缸排列形式 */
    private String engineCylinderArranged;

    /** 燃油类型 */
    private String fuelType;

    /** 燃油标号 */
    private String fuelGrade;

    /** 供油方式 */
    private String oilProviding;

    /** 排放标准 */
    private String emissionStandard;

    /** 非销售车型的其他信息，有销售车型时一般为空 */
    private List<Vehicle> vehicle;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTimeToMarket() {
        return timeToMarket;
    }

    public void setTimeToMarket(String timeToMarket) {
        this.timeToMarket = timeToMarket;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getModelSize() {
        return modelSize;
    }

    public void setModelSize(String modelSize) {
        this.modelSize = modelSize;
    }

    public String getCurbWeight() {
        return curbWeight;
    }

    public void setCurbWeight(String curbWeight) {
        this.curbWeight = curbWeight;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getShiftNum() {
        return shiftNum;
    }

    public void setShiftNum(String shiftNum) {
        this.shiftNum = shiftNum;
    }

    public String getEngineCode() {
        return engineCode;
    }

    public void setEngineCode(String engineCode) {
        this.engineCode = engineCode;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getEngineDesc() {
        return engineDesc;
    }

    public void setEngineDesc(String engineDesc) {
        this.engineDesc = engineDesc;
    }

    public String getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(String maxPower) {
        this.maxPower = maxPower;
    }

    public String getFrontBrake() {
        return frontBrake;
    }

    public void setFrontBrake(String frontBrake) {
        this.frontBrake = frontBrake;
    }

    public String getRearBrake() {
        return rearBrake;
    }

    public void setRearBrake(String rearBrake) {
        this.rearBrake = rearBrake;
    }

    public String getAssistType() {
        return assistType;
    }

    public void setAssistType(String assistType) {
        this.assistType = assistType;
    }

    public String getWheelBase() {
        return wheelBase;
    }

    public void setWheelBase(String wheelBase) {
        this.wheelBase = wheelBase;
    }

    public String getWheelBaseFont() {
        return wheelBaseFont;
    }

    public void setWheelBaseFont(String wheelBaseFont) {
        this.wheelBaseFont = wheelBaseFont;
    }

    public String getWheelBaseRear() {
        return wheelBaseRear;
    }

    public void setWheelBaseRear(String wheelBaseRear) {
        this.wheelBaseRear = wheelBaseRear;
    }

    public String getFrontTire() {
        return frontTire;
    }

    public void setFrontTire(String frontTire) {
        this.frontTire = frontTire;
    }

    public String getRearTire() {
        return rearTire;
    }

    public void setRearTire(String rearTire) {
        this.rearTire = rearTire;
    }

    public String getSpareTire() {
        return spareTire;
    }

    public void setSpareTire(String spareTire) {
        this.spareTire = spareTire;
    }

    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransDes() {
        return transDes;
    }

    public void setTransDes(String transDes) {
        this.transDes = transDes;
    }

    public String getEngineGasIn() {
        return engineGasIn;
    }

    public void setEngineGasIn(String engineGasIn) {
        this.engineGasIn = engineGasIn;
    }

    public String getEngineGasinNumber() {
        return engineGasinNumber;
    }

    public void setEngineGasinNumber(String engineGasinNumber) {
        this.engineGasinNumber = engineGasinNumber;
    }

    public String getEngineCylinderArranged() {
        return engineCylinderArranged;
    }

    public void setEngineCylinderArranged(String engineCylinderArranged) {
        this.engineCylinderArranged = engineCylinderArranged;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelGrade() {
        return fuelGrade;
    }

    public void setFuelGrade(String fuelGrade) {
        this.fuelGrade = fuelGrade;
    }

    public String getOilProviding() {
        return oilProviding;
    }

    public void setOilProviding(String oilProviding) {
        this.oilProviding = oilProviding;
    }

    public String getEmissionStandard() {
        return emissionStandard;
    }

    public void setEmissionStandard(String emissionStandard) {
        this.emissionStandard = emissionStandard;
    }

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    /** 非销售车型的其他属性。 */
    public static class Vehicle {

        /** 属性 */
        private String key;

        /** 属性值 */
        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
}
