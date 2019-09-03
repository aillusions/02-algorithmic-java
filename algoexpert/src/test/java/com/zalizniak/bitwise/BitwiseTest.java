package com.zalizniak.bitwise;

import org.junit.Test;

import java.math.BigInteger;
import java.nio.ByteBuffer;

public class BitwiseTest {

    @Test
    public void testBitwiseOperations() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + " -> " + (i << 1));
        }
    }

    @Test
    public void intToBytes() {
        for (byte b : intToBytes(Integer.MIN_VALUE)) {
            System.out.format("0x%x ", b);
        }

        System.out.println();

        for (byte b : intToByteArray(800)) {
            System.out.format("0x%x ", b);
        }

        System.out.println();

        for (byte b : integerToBytes(Integer.MAX_VALUE)) {
            System.out.format("0x%x ", b);
        }

        System.out.println();
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
