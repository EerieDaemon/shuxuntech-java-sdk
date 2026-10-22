package com.shuxuntech.sdk.internal;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * SDK 内部共享的 Jackson {@link ObjectMapper}。
 *
 * <p>反序列化时忽略未知字段，平台新增字段不会导致调用失败。
 * 该类不是公开 API，后续版本可能调整。</p>
 */
public final class Json {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private Json() {
    }

    /**
     * 返回共享的 ObjectMapper，线程安全，调用方不应修改其配置。
     */
    public static ObjectMapper mapper() {
        return MAPPER;
    }
}
