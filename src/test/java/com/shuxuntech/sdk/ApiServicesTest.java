package com.shuxuntech.sdk;

import com.shuxuntech.sdk.api.BankcardApi;
import com.shuxuntech.sdk.api.EnterpriseApi;
import com.shuxuntech.sdk.api.ExpressApi;
import com.shuxuntech.sdk.api.IdentityApi;
import com.shuxuntech.sdk.api.IpApi;
import com.shuxuntech.sdk.api.MobileApi;
import com.shuxuntech.sdk.api.OcrApi;
import com.shuxuntech.sdk.api.VehicleApi;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.result.IdCardCheckResult;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ApiServicesTest {

    private static final List<Class<?>> SERVICES = Arrays.asList(
            IdentityApi.class, MobileApi.class, BankcardApi.class, OcrApi.class,
            EnterpriseApi.class, VehicleApi.class, ExpressApi.class, IpApi.class);

    private MockWebServer server;
    private ShuxunClient client;

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();
        client = ShuxunClient.builder()
                .baseUrl(server.url("/").toString())
                .appKey("test-app-key")
                .appSecret("test-app-secret")
                .build();
    }

    @AfterEach
    void tearDown() throws IOException {
        client.close();
        server.shutdown();
    }

    @Test
    void shouldCallIdCardCheckWithTypedResult() throws Exception {
        server.enqueue(json("{\"code\":0,\"msg\":\"成功\",\"data\":{\"result\":1,\"resultDesc\":\"核验一致\"}}"));

        ApiResponse<IdCardCheckResult> response =
                client.apis().identity().idCardCheck("张三", "110101199001011234");

        assertTrue(response.isSuccess());
        assertEquals(Integer.valueOf(1), response.getData().getResult());

        RecordedRequest request = server.takeRequest(5, TimeUnit.SECONDS);
        assertNotNull(request);
        assertEquals("/v1/idCard/check", request.getPath());
        String body = request.getBody().readUtf8();
        assertTrue(body.contains("name=%E5%BC%A0%E4%B8%89"), body);
        assertTrue(body.contains("idCard=110101199001011234"), body);
    }

    @Test
    void shouldOmitNullOptionalParams() throws Exception {
        server.enqueue(json("{\"code\":0}"));

        client.apis().enterprise().enterpriseLikeQuery("杭州数勋");

        RecordedRequest request = server.takeRequest(5, TimeUnit.SECONDS);
        assertNotNull(request);
        String body = request.getBody().readUtf8();
        assertTrue(body.startsWith("keyword="), body);
        assertFalse(body.contains("pageNo"), body);
        assertFalse(body.contains("pageSize"), body);
    }

    @Test
    void shouldSendImageForOcr() throws Exception {
        server.enqueue(json("{\"code\":0}"));

        client.apis().ocr().wordOcr("aGVsbG8=", null);

        RecordedRequest request = server.takeRequest(5, TimeUnit.SECONDS);
        assertNotNull(request);
        assertEquals("/v1/word/ocr", request.getPath());
        assertEquals("image=aGVsbG8%3D", request.getBody().readUtf8());
    }

    @Test
    void shouldExposeAllServices() {
        assertNotNull(client.apis().identity());
        assertNotNull(client.apis().mobile());
        assertNotNull(client.apis().bankcard());
        assertNotNull(client.apis().ocr());
        assertNotNull(client.apis().enterprise());
        assertNotNull(client.apis().vehicle());
        assertNotNull(client.apis().express());
        assertNotNull(client.apis().ip());
    }

    /**
     * 逐个调用所有强类型方法，确认都发往 /v1 下且路径互不重复。
     */
    @Test
    void everyMethodShouldPostToDistinctPath() throws Exception {
        Set<String> paths = new HashSet<String>();
        int calls = 0;

        for (Class<?> type : SERVICES) {
            Object service = type.getConstructor(ShuxunClient.class).newInstance(client);
            for (Method method : methodsWithoutOverloads(type)) {
                server.enqueue(json("{\"code\":0}"));
                method.invoke(service, argumentsFor(method));

                RecordedRequest request = server.takeRequest(5, TimeUnit.SECONDS);
                assertNotNull(request, method.getName());
                assertTrue(request.getPath().startsWith("/v1/"), method.getName() + " -> " + request.getPath());
                paths.add(request.getPath());
                calls++;
            }
        }

        assertEquals(calls, paths.size(), "接口路径不应重复: " + paths);
        assertTrue(calls >= 40, "强类型方法数量异常: " + calls);
    }

    private static List<Method> methodsWithoutOverloads(Class<?> type) {
        Map<String, Method> byName = new HashMap<String, Method>();
        for (Method method : type.getDeclaredMethods()) {
            if (!Modifier.isPublic(method.getModifiers())) {
                continue;
            }
            Method current = byName.get(method.getName());
            if (current == null || method.getParameterTypes().length > current.getParameterTypes().length) {
                byName.put(method.getName(), method);
            }
        }
        return Arrays.asList(byName.values().toArray(new Method[0]));
    }

    private static Object[] argumentsFor(Method method) {
        Class<?>[] types = method.getParameterTypes();
        Object[] args = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            if (types[i] == String.class) {
                args[i] = "x";
            } else if (types[i] == Integer.class) {
                args[i] = 1;
            } else if (types[i] == int.class) {
                args[i] = 1;
            } else {
                fail("未预期的方法参数类型: " + types[i]);
            }
        }
        return args;
    }

    private static MockResponse json(String body) {
        return new MockResponse()
                .setResponseCode(200)
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setBody(body);
    }
}
