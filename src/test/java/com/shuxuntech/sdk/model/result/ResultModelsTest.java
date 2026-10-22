package com.shuxuntech.sdk.model.result;

import com.shuxuntech.sdk.internal.Json;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * 校验内置响应模型：字段都有访问器、都能被 Jackson 反序列化、典型结构映射正确。
 */
class ResultModelsTest {

    @Test
    void everyModelShouldHaveAccessorsAndBeDeserializable() throws Exception {
        for (Class<?> type : modelClasses()) {
            checkAccessors(type);
            assertNotNull(Json.mapper().readValue("{}", type), type.getSimpleName());
        }
    }

    private static void checkAccessors(Class<?> type) {
        for (Field field : type.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            String cap = Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1);
            try {
                assertNotNull(type.getMethod("get" + cap), type.getSimpleName() + "." + field.getName());
                assertNotNull(type.getMethod("set" + cap, field.getType()),
                        type.getSimpleName() + "." + field.getName());
            } catch (NoSuchMethodException e) {
                fail(type.getSimpleName() + " 缺少 " + field.getName() + " 的访问器: " + e.getMessage());
            }
        }
        for (Class<?> nested : type.getDeclaredClasses()) {
            checkAccessors(nested);
        }
    }

    @Test
    void shouldMapSnakeCaseOcrResponse() throws Exception {
        String json = "{\"result\":1,\"text_info\":[{\"line_no\":1,\"confidence\":0.98,"
                + "\"line_content\":\"数勋科技\",\"line_position\":{\"x\":10,\"width\":100,"
                + "\"y\":20,\"height\":30,\"line_direction\":0}}]}";

        WordOcrResult result = Json.mapper().readValue(json, WordOcrResult.class);

        assertEquals(Integer.valueOf(1), result.getResult());
        assertEquals("数勋科技", result.getText_info().get(0).getLine_content());
        assertEquals(Integer.valueOf(10), result.getText_info().get(0).getLine_position().getX());
    }

    @Test
    void shouldMapInheritedIdCardFields() throws Exception {
        String json = "{\"result\":1,\"resultDesc\":\"核验一致\",\"birthday\":\"19930123\","
                + "\"gender\":1,\"age\":32,\"province\":\"浙江省\"}";

        IdCardCheckResult result = Json.mapper().readValue(json, IdCardCheckResult.class);

        assertEquals(Integer.valueOf(1), result.getResult());
        assertEquals("19930123", result.getBirthday());
        assertEquals(Integer.valueOf(1), result.getGender());
        assertEquals("浙江省", result.getProvince());
    }

    @Test
    void shouldMapNestedEnterpriseInfo() throws Exception {
        String json = "{\"result\":1,\"info\":{\"companyName\":\"杭州数勋科技有限公司\","
                + "\"industry\":{\"industry\":\"信息传输、软件和信息技术服务业\"},"
                + "\"contacts\":{\"phoneNumber\":[{\"note\":\"总机\",\"value\":\"0571-12345678\"}]}}}";

        EnterpriseBaseInfoResult result = Json.mapper().readValue(json, EnterpriseBaseInfoResult.class);

        assertEquals("杭州数勋科技有限公司", result.getInfo().getCompanyName());
        assertEquals("信息传输、软件和信息技术服务业", result.getInfo().getIndustry().getIndustry());
        assertEquals("0571-12345678",
                result.getInfo().getContacts().getPhoneNumber().get(0).getValue());
    }

    @Test
    void shouldKeepResultDescFromResponse() throws Exception {
        String json = "{\"resultDesc\":\"服务端描述\",\"result\":1}";

        IdCardCheckResult result = Json.mapper().readValue(json, IdCardCheckResult.class);

        assertEquals("服务端描述", result.getResultDesc());
    }

    private static List<Class<?>> modelClasses() throws Exception {
        URL url = ResultModelsTest.class.getResource("/com/shuxuntech/sdk/model/result");
        assertNotNull(url, "找不到响应模型目录");
        File dir = new File(url.toURI());
        File[] files = dir.listFiles((d, name) -> name.endsWith(".class") && !name.contains("$"));
        assertNotNull(files, "响应模型目录为空");

        List<Class<?>> classes = new ArrayList<Class<?>>();
        for (File file : files) {
            String name = file.getName().substring(0, file.getName().length() - ".class".length());
            classes.add(Class.forName("com.shuxuntech.sdk.model.result." + name));
        }
        return classes;
    }
}
