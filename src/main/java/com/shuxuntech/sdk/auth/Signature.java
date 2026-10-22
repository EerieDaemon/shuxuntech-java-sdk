package com.shuxuntech.sdk.auth;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 数勋开放平台的签名工具。
 *
 * <p>签名规则：{@code sign = sha256(appKey + timestamp + appSecret)}，
 * 结果取小写十六进制字符串，{@code timestamp} 为毫秒时间戳。
 * 服务端要求客户端时间与服务器时间偏差不超过 5 分钟，否则返回 {@code code = 4}。</p>
 *
 * <p>本类无状态、线程安全，通常不需要直接调用，{@link com.shuxuntech.sdk.ShuxunClient}
 * 会在每次请求时自动完成签名。</p>
 */
public final class Signature {

    private static final char[] HEX = "0123456789abcdef".toCharArray();

    private Signature() {
    }

    /**
     * 按平台规则生成签名。
     *
     * @param appKey          应用 appKey
     * @param appSecret       应用 appSecret
     * @param timestampMillis 毫秒时间戳
     * @return 64 位小写十六进制签名字符串
     */
    public static String sign(String appKey, String appSecret, long timestampMillis) {
        if (appKey == null || appSecret == null) {
            throw new IllegalArgumentException("appKey 和 appSecret 不能为空");
        }
        return sha256Hex(appKey + timestampMillis + appSecret);
    }

    /**
     * 计算字符串的 SHA-256，返回小写十六进制字符串。
     *
     * @param value 待计算内容，按 UTF-8 编码
     * @return 64 位小写十六进制字符串
     */
    public static String sha256Hex(String value) {
        if (value == null) {
            throw new IllegalArgumentException("value 不能为空");
        }
        return sha256Hex(value.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 计算字节数组的 SHA-256，返回小写十六进制字符串。
     *
     * @param value 待计算内容
     * @return 64 位小写十六进制字符串
     */
    public static String sha256Hex(byte[] value) {
        if (value == null) {
            throw new IllegalArgumentException("value 不能为空");
        }
        try {
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(value);
            char[] out = new char[digest.length * 2];
            for (int i = 0; i < digest.length; i++) {
                int b = digest[i] & 0xFF;
                out[i * 2] = HEX[b >>> 4];
                out[i * 2 + 1] = HEX[b & 0x0F];
            }
            return new String(out);
        } catch (NoSuchAlgorithmException e) {
            // 所有 JRE 都必须实现 SHA-256，正常不会走到这里
            throw new IllegalStateException("当前 JVM 不支持 SHA-256", e);
        }
    }
}
