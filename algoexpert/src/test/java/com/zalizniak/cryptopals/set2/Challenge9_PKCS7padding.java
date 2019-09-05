package com.zalizniak.cryptopals.set2;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Challenge9_PKCS7padding {

    @Test
    public void test() {
        String origString = "YELLOW SUBMARINE";
        byte[] orig = origString.getBytes(StandardCharsets.UTF_8);
        byte[] padded = padBlock(orig, 20);
        System.out.println(Arrays.toString(orig) + " -> " + Arrays.toString(padded));
        Assert.assertArrayEquals(new byte[]{89, 69, 76, 76, 79, 87, 32, 83, 85, 66, 77, 65, 82, 73, 78, 69, 4, 4, 4, 4}, padded);
    }

    @Test
    public void test2() {
        String origString = "YELLOW SUBMARINE";
        byte[] orig = origString.getBytes(StandardCharsets.UTF_8);
        byte[] padded = padBlock(orig, 19);
        System.out.println(Arrays.toString(orig) + " -> " + Arrays.toString(padded));
        Assert.assertArrayEquals(new byte[]{89, 69, 76, 76, 79, 87, 32, 83, 85, 66, 77, 65, 82, 73, 78, 69, 3, 3, 3}, padded);
    }

    /**
     * The value of each added byte is the number of bytes that are added, i.e. N bytes, each of value N are added.
     * The number of bytes added will depend on the block boundary to which the message needs to be extended.
     */
    public static byte[] padBlock(byte[] block, int blockSize) {
        if (block.length == blockSize) {
            return block;
        }
        byte PADDING_SYMBOL = (byte) (blockSize - block.length);
        byte[] rv = new byte[blockSize];
        System.arraycopy(block, 0, rv, 0, block.length);
        for (int i = blockSize - 1; i >= block.length; i--) {
            rv[i] = PADDING_SYMBOL;
        }
        return rv;
    }
}
