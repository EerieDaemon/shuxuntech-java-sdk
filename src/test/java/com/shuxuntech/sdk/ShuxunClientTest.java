package com.shuxuntech.sdk;

import com.fasterxml.jackson.databind.JsonNode;
import com.shuxuntech.sdk.auth.Signature;
import com.shuxuntech.sdk.exception.ShuxunApiException;
import com.shuxuntech.sdk.exception.ShuxunTransportException;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.Params;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShuxunClientTest {

    private static final String APP_KEY = "test-app-key";
    private static final String APP_SECRET = "test-app-secret";

    private MockWebServer server;
    private ShuxunClient client;

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();
        client = ShuxunClient.builder()
                .baseUrl(server.url("/").toString())
                .appKey(APP_KEY)
                .appSecret(APP_SECRET)
                .build();
    }

    @AfterEach
    void tearDown() throws IOException {
        client.close();
        server.shutdown();
    }

    @Test
    void shouldPostSignedFormAndParseTypedData() throws Exception {
        server.enqueue(jsonResponse("{\"code\":0,\"msg\":\"成功\",\"seqNo\":\"seq-001\","
                + "\"data\":{\"name\":\"张三\",\"idCard\":\"110101199001011234\"}}"));

        ApiResponse<IdCardResult> response = client.post(
                "/v1/ocr/idcard",
                Params.create().put("name", "张三").put("idCard", "110101199001011234"),
                IdCardResult.class);

        assertTrue(response.isSuccess());
        assertNotNull(response.getData());
        assertEquals("张三", response.getData().getName());
        assertEquals("110101199001011234", response.getData().getIdCard());
        assertEquals("seq-001", response.getSeqNo());

        RecordedRequest request = server.takeRequest(5, TimeUnit.SECONDS);
        assertNotNull(request);
        assertEquals("POST", request.getMethod());
        assertEquals("/v1/ocr/idcard", request.getPath());
        assertEquals(APP_KEY, request.getHeader("appKey"));

        String timestamp = request.getHeader("timestamp");
        assertNotNull(timestamp);
        assertEquals(Signature.sign(APP_KEY, APP_SECRET, Long.parseLong(timestamp)),
                request.getHeader("sign"));
        assertTrue(request.getHeader("Content-Type").startsWith("application/x-www-form-urlencoded"));

        String body = request.getBody().readUtf8();
        assertTrue(body.contains("name=%E5%BC%A0%E4%B8%89"), body);
        assertTrue(body.contains("idCard=110101199001011234"), body);
    }

    @Test
    void shouldReturnBusinessErrorWithoutThrowing() {
        server.enqueue(jsonResponse("{\"code\":2,\"msg\":\"无记录\",\"seqNo\":\"seq-002\"}"));

        ApiResponse<JsonNode> response = client.post("/v1/enterprise/query", Params.create());

        assertFalse(response.isSuccess());
        assertEquals(2, response.getCode().intValue());
        assertEquals("无记录", response.getMsg());
    }

    @Test
    void postOrThrowShouldThrowOnBusinessError() {
        server.enqueue(jsonResponse("{\"code\":4,\"msg\":\"签名错误\",\"seqNo\":\"seq-003\"}"));

        ShuxunApiException exception = assertThrows(ShuxunApiException.class,
                () -> client.postOrThrow("/v1/test", Params.create()));

        assertEquals(4, exception.getCode());
        assertEquals("签名错误", exception.getMsg());
        assertEquals("seq-003", exception.getSeqNo());
    }

    @Test
    void shouldThrowOnNon2xxStatus() {
        server.enqueue(new MockResponse().setResponseCode(500).setBody("{\"error\":\"boom\"}"));

        ShuxunTransportException exception = assertThrows(ShuxunTransportException.class,
                () -> client.post("/v1/test", Params.create()));

        assertEquals(500, exception.getHttpStatus());
    }

    @Test
    void shouldThrowOnInvalidJson() {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("<html>bad gateway</html>"));

        assertThrows(ShuxunTransportException.class,
                () -> client.post("/v1/test", Params.create()));
    }

    @Test
    void shouldValidateRequiredConfiguration() {
        assertThrows(IllegalArgumentException.class, () -> ShuxunClient.builder().build());
        assertThrows(IllegalArgumentException.class,
                () -> ShuxunClient.builder().appKey("k").build());
        assertThrows(IllegalArgumentException.class,
                () -> ShuxunClient.builder().appKey("k").appSecret("s")
                        .readTimeout(Duration.ZERO).build());
    }

    private static MockResponse jsonResponse(String body) {
        return new MockResponse()
                .setResponseCode(200)
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setBody(body);
    }

    /**
     * 强类型业务数据示例。
     */
    public static class IdCardResult {

        private String name;
        private String idCard;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }
    }
}
