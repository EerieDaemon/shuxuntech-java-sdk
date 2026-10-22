package com.shuxuntech.sdk.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.shuxuntech.sdk.internal.Json;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApiResponseTest {

    @Test
    void shouldParseSuccessResponseAndIgnoreUnknownFields() throws Exception {
        String json = "{\"code\":0,\"msg\":\"成功\",\"seqNo\":\"abc\",\"data\":{\"ok\":true},\"unknown\":1}";

        ApiResponse<JsonNode> response = Json.mapper().readValue(
                json, new TypeReference<ApiResponse<JsonNode>>() {
                });

        assertTrue(response.isSuccess());
        assertEquals("成功", response.getMsg());
        assertEquals("abc", response.getSeqNo());
        assertTrue(response.getData().get("ok").asBoolean());
    }

    @Test
    void missingCodeShouldNotBeSuccess() throws Exception {
        ApiResponse<JsonNode> response = Json.mapper().readValue(
                "{\"msg\":\"服务异常\"}", new TypeReference<ApiResponse<JsonNode>>() {
                });

        assertFalse(response.isSuccess());
    }

    @Test
    void shouldDescribeCodes() {
        assertEquals("成功", ResponseCodes.describe(ResponseCodes.SUCCESS));
        assertEquals("签名错误", ResponseCodes.describe(ResponseCodes.SIGN_ERROR));
        assertEquals("无记录", ResponseCodes.describe(ResponseCodes.NO_RECORD));
        assertEquals("未知返回码", ResponseCodes.describe(1234));
    }
}
