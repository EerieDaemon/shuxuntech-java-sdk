package com.shuxuntech.sdk.model.result;

/** VIN车架号查询精准版返回结果。 */
public class Vin2Result {

    /** 查询结果，1:查询成功，2:无记录 */
    private Integer result;

    /** 车辆信息 */
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

        /** 发动机号 */
        private String engineno;

        /** 燃料种类 */
        private String fueltype;

        /** 总质量 */
        private String totalweight;

        /** 颜色 */
        private String color;

        /** 生产日期 */
        private String productiondate;

        /** 车等级，暂时没用 */
        private String carlevel;

        /** 后轮距 */
        private String reartrack;

        /** 货箱栏板内尺寸高 */
        private String boxheight;

        /** 发动机型号 */
        private String enginemodel;

        /** 油耗 */
        private String comfuelconsumption;

        /** 货箱栏板内尺寸宽 */
        private String boxwidth;

        /** 前轮距 */
        private String fronttrack;

        /** 外形尺寸(mm) 长 */
        private String len;

        /** 指导价格 */
        private String price;

        /** 车体结构 */
        private String bodytype;

        /** 排量 */
        private String displacement;

        /** 车辆型号 */
        private String model;

        /** 车架号 */
        private String vin;

        /** 车品牌 */
        private String brand;

        /** 排放标准 */
        private String environmentalstandards;

        /** 外形尺寸(mm)高 */
        private String height;

        /** 驱动方式 */
        private String drivemode;

        /** 额定载质量(kg) */
        private String ratedloadweight;

        /** 最大功率(kW) */
        private String maxpower;

        /** 排量(ml) */
        private String displacementml;

        /** 货箱栏板内尺寸(mm) 长 */
        private String boxlen;

        /** 整备质量(kg) */
        private String weight;

        /** 轮胎数 */
        private String tirenum;

        /** 轮胎规格 */
        private String tiresize;

        /** 车组 */
        private String groupname;

        /** 年款 */
        private String yeartype;

        /** 座位数 */
        private String seatnum;

        /** 轴距 */
        private String wheelbase;

        /** 轴数 */
        private String axlenum;

        /** 车系名称 */
        private String name;

        /** 外形尺寸(mm)宽 */
        private String width;

        public String getEngineno() {
            return engineno;
        }

        public void setEngineno(String engineno) {
            this.engineno = engineno;
        }

        public String getFueltype() {
            return fueltype;
        }

        public void setFueltype(String fueltype) {
            this.fueltype = fueltype;
        }

        public String getTotalweight() {
            return totalweight;
        }

        public void setTotalweight(String totalweight) {
            this.totalweight = totalweight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getProductiondate() {
            return productiondate;
        }

        public void setProductiondate(String productiondate) {
            this.productiondate = productiondate;
        }

        public String getCarlevel() {
            return carlevel;
        }

        public void setCarlevel(String carlevel) {
            this.carlevel = carlevel;
        }

        public String getReartrack() {
            return reartrack;
        }

        public void setReartrack(String reartrack) {
            this.reartrack = reartrack;
        }

        public String getBoxheight() {
            return boxheight;
        }

        public void setBoxheight(String boxheight) {
            this.boxheight = boxheight;
        }

        public String getEnginemodel() {
            return enginemodel;
        }

        public void setEnginemodel(String enginemodel) {
            this.enginemodel = enginemodel;
        }

        public String getComfuelconsumption() {
            return comfuelconsumption;
        }

        public void setComfuelconsumption(String comfuelconsumption) {
            this.comfuelconsumption = comfuelconsumption;
        }

        public String getBoxwidth() {
            return boxwidth;
        }

        public void setBoxwidth(String boxwidth) {
            this.boxwidth = boxwidth;
        }

        public String getFronttrack() {
            return fronttrack;
        }

        public void setFronttrack(String fronttrack) {
            this.fronttrack = fronttrack;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getBodytype() {
            return bodytype;
        }

        public void setBodytype(String bodytype) {
            this.bodytype = bodytype;
        }

        public String getDisplacement() {
            return displacement;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
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

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getEnvironmentalstandards() {
            return environmentalstandards;
        }

        public void setEnvironmentalstandards(String environmentalstandards) {
            this.environmentalstandards = environmentalstandards;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getDrivemode() {
            return drivemode;
        }

        public void setDrivemode(String drivemode) {
            this.drivemode = drivemode;
        }

        public String getRatedloadweight() {
            return ratedloadweight;
        }

        public void setRatedloadweight(String ratedloadweight) {
            this.ratedloadweight = ratedloadweight;
        }

        public String getMaxpower() {
            return maxpower;
        }

        public void setMaxpower(String maxpower) {
            this.maxpower = maxpower;
        }

        public String getDisplacementml() {
            return displacementml;
        }

        public void setDisplacementml(String displacementml) {
            this.displacementml = displacementml;
        }

        public String getBoxlen() {
            return boxlen;
        }

        public void setBoxlen(String boxlen) {
            this.boxlen = boxlen;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getTirenum() {
            return tirenum;
        }

        public void setTirenum(String tirenum) {
            this.tirenum = tirenum;
        }

        public String getTiresize() {
            return tiresize;
        }

        public void setTiresize(String tiresize) {
            this.tiresize = tiresize;
        }

        public String getGroupname() {
            return groupname;
        }

        public void setGroupname(String groupname) {
            this.groupname = groupname;
        }

        public String getYeartype() {
            return yeartype;
        }

        public void setYeartype(String yeartype) {
            this.yeartype = yeartype;
        }

        public String getSeatnum() {
            return seatnum;
        }

        public void setSeatnum(String seatnum) {
            this.seatnum = seatnum;
        }

        public String getWheelbase() {
            return wheelbase;
        }

        public void setWheelbase(String wheelbase) {
            this.wheelbase = wheelbase;
        }

        public String getAxlenum() {
            return axlenum;
        }

        public void setAxlenum(String axlenum) {
            this.axlenum = axlenum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

    }
}
