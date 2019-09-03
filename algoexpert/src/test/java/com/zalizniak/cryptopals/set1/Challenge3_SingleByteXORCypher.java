package com.zalizniak.cryptopals.set1;

import org.junit.Test;

/**
 * https://cryptopals.com/sets/1/challenges/3
 */
public class Challenge3_SingleByteXORCypher {

    char[] CHARS = "abcdef0123456789".toCharArray();
    //char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    private static final int RADIX = 16;

    @Test
    public void test() {
        final String XORed = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
        final String decrypted = "746865206b696420646f6e277420706c6179";

        for (char aChar : CHARS) {
            System.out.println(Challenge2_XOR.fixedXOR(XORed, fillAString(aChar, XORed.length())));
        }

    }

    private static final String fillAString(char character, int size) {
        char[] rv = new char[size];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = character;
        }
        return new String(rv);
    }

}