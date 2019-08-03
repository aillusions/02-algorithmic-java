package com.zalizniak.caesar_cipher;

import junit.framework.TestCase;

public class CaesarCipherTest extends TestCase {

    public void testShiftIdx() {
        assertEquals(1, CaesarCipher.shiftIdx(0, 1));
        assertEquals(2, CaesarCipher.shiftIdx(0, 2));

        assertEquals(0, CaesarCipher.shiftIdx(2, -2));
    }

}
