package com.shuxuntech.sdk.example;

/**
 * 身份证实名核验结果示例。
 *
 * <p>字段与平台 {@code /v1/idCard/check} 返回的 {@code data} 一一对应，
 * 对应 sx-data 项目中的 {@code com.shuxun.data.api.result.IdCardCheckResult}
 * （其生日、性别、地区等公共字段来自 {@code IdCardCommonResult}，序列化后是同一层 JSON）。</p>
 *
 * <p>调用示例：</p>
 * <pre>{@code
 * ApiResponse<IdCardCheckResult> response = client.post(
 *         "/v1/idCard/check",
 *         Params.create().put("name", "张三").put("idCard", "110101199001011234"),
 *         IdCardCheckResult.class);
 * }</pre>
 */
public class IdCardCheckResult {

    /** 1：一致；2：不一致；3：无记录（不计费）。 */
    private Integer result;

    /** 核验结果描述。 */
    private String resultDesc;

    /** 生日，格式 {@code yyyyMMdd}，例如 {@code 19930123}。 */
    private String birthday;

    /** 性别：{@code 1} 男，{@code 0} 女。 */
    private Integer gender;

    /** 年龄。 */
    private Integer age;

    /** 省份。 */
    private String province;

    /** 城市。 */
    private String city;

    /** 区县。 */
    private String district;

    /** 籍贯。 */
    private String area;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
