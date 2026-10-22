package com.shuxuntech.sdk.auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SignatureTest {

    /**
     * 平台文档示例：appKey=aaa，timestamp=1682476980429，appSecret=bbb。
     */
    @Test
    void shouldMatchPlatformExample() {
        String sign = Signature.sign("aaa", "bbb", 1682476980429L);
        assertEquals("0eec436dea613cff2267aadcab7ad89f6eb9146a8bef579966e665e83eddaf51", sign);
    }

    @Test
    void shouldHashUtf8Text() {
        assertEquals("1db803e5431874f826064d5e1c6dcf51fc56e2b5f0c457ed6bb4d8417bf4af9b",
                Signature.sha256Hex("数勋"));
    }

    @Test
    void shouldProduceLowercaseHex() {
        String sign = Signature.sign("key", "secret", 1L);
        assertEquals(64, sign.length());
        assertEquals(sign.toLowerCase(), sign);
    }

    @Test
    void shouldRejectNullArguments() {
        assertThrows(IllegalArgumentException.class, () -> Signature.sign(null, "secret", 1L));
        assertThrows(IllegalArgumentException.class, () -> Signature.sign("key", null, 1L));
        assertThrows(IllegalArgumentException.class, () -> Signature.sha256Hex((String) null));
    }
}
