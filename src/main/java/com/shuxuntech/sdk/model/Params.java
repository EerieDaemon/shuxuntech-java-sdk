package com.shuxuntech.sdk.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 接口请求参数，按 {@code application/x-www-form-urlencoded} 提交。
 *
 * <p>参数值为 {@code null} 时表示删除该参数，不会被提交；其余值会通过
 * {@link String#valueOf(Object)} 转成字符串。</p>
 *
 * <p>示例：</p>
 * <pre>{@code
 * Params params = Params.create()
 *         .put("name", "张三")
 *         .put("idCard", "110101199001011234");
 * }</pre>
 */
public final class Params {

    private final Map<String, String> values = new LinkedHashMap<String, String>();

    private Params() {
    }

    /**
     * 创建空参数集合。
     */
    public static Params create() {
        return new Params();
    }

    /**
     * 创建只包含一个参数的集合。
     */
    public static Params of(String name, Object value) {
        return create().put(name, value);
    }

    /**
     * 设置字符串参数。
     *
     * @param name  参数名，不可为空
     * @param value 参数值，为 {@code null} 时删除该参数
     * @return 当前对象，便于链式调用
     */
    public Params put(String name, String value) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("参数名不能为空");
        }
        if (value == null) {
            values.remove(name);
        } else {
            values.put(name, value);
        }
        return this;
    }

    /**
     * 设置参数，非字符串值按 {@link String#valueOf(Object)} 转换。
     *
     * @param name  参数名，不可为空
     * @param value 参数值，为 {@code null} 时删除该参数
     * @return 当前对象，便于链式调用
     */
    public Params put(String name, Object value) {
        return put(name, value == null ? null : String.valueOf(value));
    }

    /**
     * 删除参数。
     *
     * @return 当前对象，便于链式调用
     */
    public Params remove(String name) {
        values.remove(name);
        return this;
    }

    /**
     * 是否没有任何参数。
     */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * 参数个数。
     */
    public int size() {
        return values.size();
    }

    /**
     * 只读参数视图，保持插入顺序。
     */
    public Map<String, String> asMap() {
        return Collections.unmodifiableMap(values);
    }

    /**
     * 只输出参数名，避免把身份证号、手机号等敏感值写进日志。
     */
    @Override
    public String toString() {
        return "Params" + values.keySet();
    }
}
