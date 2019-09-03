package com.zalizniak.cryptopals.set1;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://cryptopals.com/sets/1/challenges/2
 */
public class Challenge2_XOR {


    @Test
    public void test() {
        final String base16A = "1c0111001f010100061a024b53535009181c";
        final String base16B = "686974207468652062756c6c277320657965";
        final String XORed = "746865206b696420646f6e277420706c6179";

        Assert.assertEquals(XORed, fixedXOR(base16A, base16B));

    }

    public static String fixedXOR(String inA, String inB) {
        return inA;
    }
}