package com.shuxuntech.sdk.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParamsTest {

    @Test
    void shouldKeepInsertionOrder() {
        Params params = Params.create().put("b", 2).put("a", 1);

        assertEquals(Arrays.asList("b", "a"), new ArrayList<String>(params.asMap().keySet()));
        assertEquals("2", params.asMap().get("b"));
        assertEquals(2, params.size());
        assertFalse(params.isEmpty());
    }

    @Test
    void nullValueShouldRemoveParam() {
        Params params = Params.create().put("a", "1").put("a", (String) null);

        assertTrue(params.isEmpty());
    }

    @Test
    void toStringShouldNotLeakValues() {
        Params params = Params.create().put("idCard", "110101199001011234");

        assertTrue(params.toString().contains("idCard"));
        assertFalse(params.toString().contains("110101199001011234"));
    }

    @Test
    void shouldRejectBlankName() {
        assertThrows(IllegalArgumentException.class, () -> Params.create().put(" ", "value"));
        assertThrows(IllegalArgumentException.class, () -> Params.of(null, "value"));
    }

    @Test
    void asMapShouldBeReadOnly() {
        Params params = Params.create().put("a", "1");

        assertThrows(UnsupportedOperationException.class, () -> params.asMap().put("b", "2"));
    }
}
