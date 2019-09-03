package com.zalizniak.bitwise;

import org.junit.Test;

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
        for (byte b : intToBytes(1_695_609_641)) {
            System.out.format("0x%x ", b);
        }

        System.out.println();

        for (byte b : intToByteArray(1_695_609_641)) {
            System.out.format("0x%x ", b);
        }

        System.out.println();
    }

    public static final byte[] intToBytes(int value) {
        byte[] bytes = ByteBuffer.allocate(4).putInt(1_695_609_641).array();

       return bytes;
    }
    public static final byte[] intToByteArray(int value) {
        return new byte[] {
                (byte)(value >>> 24),
                (byte)(value >>> 16),
                (byte)(value >>> 8),
                (byte)value};
    }
}
