package com.zalizniak.caesar_cipher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaesarCipherTest {

    @Test
    public void shouldNotChangeIdxForZeroShift() {
        assertEquals(0, CaesarCipher.shiftIdx(0, 0));
        assertEquals(10, CaesarCipher.shiftIdx(10, 0));
    }

    @Test
    public void shouldIncrementPositionByShift() {
        assertEquals(1, CaesarCipher.shiftIdx(0, 1));
        assertEquals(2, CaesarCipher.shiftIdx(0, 2));
        assertEquals(25, CaesarCipher.shiftIdx(0, 25));
    }

    @Test
    public void shouldDecrementPositionByShift() {
        assertEquals(0, CaesarCipher.shiftIdx(2, -2));
    }

    @Test
    public void shouldCirculatePosition() {
        assertEquals(0, CaesarCipher.shiftIdx(25, 1));
        assertEquals(0, CaesarCipher.shiftIdx(0, 26));
    }

    @Test
    public void shouldShiftChar() {
        assertEquals('e', CaesarCipher.shiftChar('a', 4));
        assertEquals('a', CaesarCipher.shiftChar('z', 1));
        assertEquals('z', CaesarCipher.shiftChar('z', 26));
    }

    @Test
    public void shouldEncode() {
        assertEquals("bcd", CaesarCipher.encode("abc", 1));
    }

    @Test
    public void shouldDecode() {
        assertEquals("abc", CaesarCipher.decode("bcd", 1));
    }

}
