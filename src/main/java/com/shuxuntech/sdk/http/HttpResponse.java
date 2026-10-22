package com.shuxuntech.sdk.http;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 传输层返回的原始 HTTP 响应。
 */
public final class HttpResponse {

    private final int status;
    private final String body;
    private final Map<String, List<String>> headers;

    public HttpResponse(int status, String body, Map<String, List<String>> headers) {
        this.status = status;
        this.body = body;
        this.headers = headers == null
                ? Collections.<String, List<String>>emptyMap()
                : Collections.unmodifiableMap(new LinkedHashMap<String, List<String>>(headers));
    }

    /**
     * HTTP 状态码。
     */
    public int getStatus() {
        return status;
    }

    /**
     * 响应体文本，通常为 JSON。
     */
    public String getBody() {
        return body;
    }

    /**
     * 响应头，key 不区分大小写地保存为小写。
     */
    public Map<String, List<String>> getHeaders() {
        return headers;
    }
}
