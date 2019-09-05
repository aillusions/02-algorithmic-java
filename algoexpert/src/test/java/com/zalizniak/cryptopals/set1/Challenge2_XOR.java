package com.zalizniak.cryptopals.set1;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * https://cryptopals.com/sets/1/challenges/2
 * <p>
 * XOR - exclusive disjunction
 */
public class Challenge2_XOR {

    private static final int RADIX = 16;

    @Test
    public void test() {
        final String base16A = "1c0111001f010100061a024b53535009181c";
        final String base16B = "686974207468652062756c6c277320657965";
        final String XORed = "746865206b696420646f6e277420706c6179";

        Assert.assertEquals(XORed, fixedXORHex(base16A, base16B));
        Assert.assertEquals(base16A, fixedXORHex(XORed, base16B));
        Assert.assertEquals(base16B, fixedXORHex(XORed, base16A));
    }

    public static String fixedXORHex(String inA, String inB) {
        byte[] in1 = new BigInteger(inA, RADIX).toByteArray();
        byte[] in2 = new BigInteger(inB, RADIX).toByteArray();
        return toHex(new String(fixedXOR(in1, in2), StandardCharsets.UTF_8));
    }

    public static String toHex(String arg) {
        return String.format("%x", new BigInteger(1, arg.getBytes(StandardCharsets.UTF_8)));
    }

    public static byte[] fixedXOR(byte[] inA, byte[] inB) {
        if (inA.length != inB.length) {
            throw new RuntimeException("Invalid args: sizes of arrays for xor expected to be the same: " + inA.length + " != " + inB.length);
        }

        byte[] rv = new byte[inA.length];
        for (int i = 0; i < inA.length; i++) {
            rv[i] = (byte) (inA[i] ^ inB[i]);
        }
        return rv;
    }
}