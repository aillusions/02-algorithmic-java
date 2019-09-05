package com.zalizniak.bitwise;

import org.junit.Test;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class BitwiseTest {

    // there are 26 letters in English: to represent all letters enough 5 bits (2 ^ 5 == 32)

    @Test
    public void testBitwiseOperations() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + " -> " + (i << 1));
        }
    }

    // 2 bytes, 65,536 characters
    @Test
    public void charToBytes() {
        char origChar = 'a';
        byte[] bytes = ByteBuffer.allocate(2).putChar(origChar).array();
        byte[] reverseBytes = ByteBuffer.allocate(2).putChar(Character.reverseBytes(origChar)).array();
        ByteBuffer reverseBuffer = ByteBuffer.wrap(reverseBytes);

        System.out.println(((int) origChar) + " == " + Arrays.toString(bytes) + "  <->  " + Arrays.toString(reverseBytes) + " == " + ((int) reverseBuffer.getChar()));
    }

    @Test
    public void intToBytes() {
        System.out.println(Integer.MAX_VALUE + " -> " + Arrays.toString(intToBytes(Integer.MAX_VALUE)));
        System.out.println(800 + " -> " + Arrays.toString(intToBytes(800)));
        System.out.println(1 + " -> " + Arrays.toString(intToBytes(1)));
        System.out.println(0 + " -> " + Arrays.toString(intToBytes(0)));
        System.out.println(Integer.MIN_VALUE + " -> " + Arrays.toString(intToBytes(Integer.MIN_VALUE)));
    }

    public static byte[] intToBytes(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }

    public static byte[] integerToBytes(int value) {
        return BigInteger.valueOf(value).toByteArray();
    }

    public static byte[] intToByteArray(int value) {
        return new byte[]{
                (byte) (value >>> 24),
                (byte) (value >>> 16),
                (byte) (value >>> 8),
                (byte) value
        };
    }
}
