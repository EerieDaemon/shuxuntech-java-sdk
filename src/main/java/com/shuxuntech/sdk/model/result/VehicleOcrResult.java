package com.shuxuntech.sdk.model.result;

/** 行驶证OCR。 */
public class VehicleOcrResult {

    /**
     * 1: 识别成功，有数据
     * 2: 识别成功，无数据
     * 3：识别失败，无法正确解析、未按要求传入参数、下载图片超时
     */
    private Integer result;

    /** 识别结果描述 */
    private String resultDesc;

    /** 主页（正页）扫描信息 */
    private Info info;

    /** 副页扫描信息 */
    private BackInfo backInfo;

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

    public BackInfo getBackInfo() {
        return backInfo;
    }

    public void setBackInfo(BackInfo backInfo) {
        this.backInfo = backInfo;
    }

    public static class Info {

        /** 所有人 */
        private String owner;

        /** 发证机关 */
        private String issuedBy;

        /** 证件面：front-主页，back-副页 */
        private String side;

        /** 住址 */
        private String address;

        /** 车辆类型 */
        private String vehicleType;

        /** 注册日期 */
        private String registerDate;

        /** 证件类型 */
        private Integer type;

        /** 发动机号 */
        private String engineNo;

        /** 发证日期 */
        private String issueDate;

        /** 号牌号码 */
        private String plateNo;

        /** 使用性质 */
        private String useCharacter;

        /** 品牌型号 */
        private String model;

        /** 车辆识别代号 */
        private String vin;

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getIssuedBy() {
            return issuedBy;
        }

        public void setIssuedBy(String issuedBy) {
            this.issuedBy = issuedBy;
        }

        public String getSide() {
            return side;
        }

        public void setSide(String side) {
            this.side = side;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public String getRegisterDate() {
            return registerDate;
        }

        public void setRegisterDate(String registerDate) {
            this.registerDate = registerDate;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getEngineNo() {
            return engineNo;
        }

        public void setEngineNo(String engineNo) {
            this.engineNo = engineNo;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(String issueDate) {
            this.issueDate = issueDate;
        }

        public String getPlateNo() {
            return plateNo;
        }

        public void setPlateNo(String plateNo) {
            this.plateNo = plateNo;
        }

        public String getUseCharacter() {
            return useCharacter;
        }

        public void setUseCharacter(String useCharacter) {
            this.useCharacter = useCharacter;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getVin() {
            return vin;
        }

        public void setVin(String vin) {
            this.vin = vin;
        }

    }
    public static class BackInfo {

        /** 证件面：front-主页，back-副页 */
        private String side;

        /** 证件类型 */
        private Integer type;

        /** 号牌号码 */
        private String plateNo;

        /** 发证机关 */
        private String issuedBy;

        /** 住址 */
        private String address;

        /** 档案编号 */
        private String fileNo;

        /** 副页编号 */
        private String subPageCode;

        /** 核定载人数 */
        private String allowNum;

        /** 总质量 */
        private String totalMass;

        /** 整备质量 */
        private String curbWeight;

        /** 核定载质量 */
        private String loadQuality;

        /** 准牵引总质量 */
        private String totalQuasiMass;

        /** 外廓尺寸 */
        private String externalSize;

        /** 燃油种类 */
        private String fuelType;

        /** 备注 */
        private String marks;

        /** 检验记录 */
        private String record;

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

        public String getPlateNo() {
            return plateNo;
        }

        public void setPlateNo(String plateNo) {
            this.plateNo = plateNo;
        }

        public String getIssuedBy() {
            return issuedBy;
        }

        public void setIssuedBy(String issuedBy) {
            this.issuedBy = issuedBy;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFileNo() {
            return fileNo;
        }

        public void setFileNo(String fileNo) {
            this.fileNo = fileNo;
        }

        public String getSubPageCode() {
            return subPageCode;
        }

        public void setSubPageCode(String subPageCode) {
            this.subPageCode = subPageCode;
        }

        public String getAllowNum() {
            return allowNum;
        }

        public void setAllowNum(String allowNum) {
            this.allowNum = allowNum;
        }

        public String getTotalMass() {
            return totalMass;
        }

        public void setTotalMass(String totalMass) {
            this.totalMass = totalMass;
        }

        public String getCurbWeight() {
            return curbWeight;
        }

        public void setCurbWeight(String curbWeight) {
            this.curbWeight = curbWeight;
        }

        public String getLoadQuality() {
            return loadQuality;
        }

        public void setLoadQuality(String loadQuality) {
            this.loadQuality = loadQuality;
        }

        public String getTotalQuasiMass() {
            return totalQuasiMass;
        }

        public void setTotalQuasiMass(String totalQuasiMass) {
            this.totalQuasiMass = totalQuasiMass;
        }

        public String getExternalSize() {
            return externalSize;
        }

        public void setExternalSize(String externalSize) {
            this.externalSize = externalSize;
        }

        public String getFuelType() {
            return fuelType;
        }

        public void setFuelType(String fuelType) {
            this.fuelType = fuelType;
        }

        public String getMarks() {
            return marks;
        }

        public void setMarks(String marks) {
            this.marks = marks;
        }

        public String getRecord() {
            return record;
        }

        public void setRecord(String record) {
            this.record = record;
        }

    }
}
