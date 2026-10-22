package com.shuxuntech.sdk.http;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

/**
 * HTTP 传输层抽象，默认实现基于 OkHttp。
 *
 * <p>需要接入自定义代理、链路追踪或测试替身时，实现本接口并通过
 * {@code ShuxunClient.Builder#transport(HttpTransport)} 注入。</p>
 */
public interface HttpTransport extends Closeable {

    /**
     * 以 {@code application/x-www-form-urlencoded} 方式提交 POST 请求。
     *
     * @param url     完整请求地址
     * @param headers 请求头
     * @param form    表单参数
     * @return 原始响应
     * @throws IOException 网络或 IO 失败
     */
    HttpResponse post(String url, Map<String, String> headers, Map<String, String> form) throws IOException;

    @Override
    void close() throws IOException;
}
