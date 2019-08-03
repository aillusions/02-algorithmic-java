package com.zalizniak.caesar_cipher;


import java.util.HashMap;
import java.util.Map;

/**
 * Method in which each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet.
 * The method is named after Julius Caesar, who used it in his private correspondence.
 */
public class CaesarCipher {

    private static final char[] ALPHABET = {
            'a', // 0
            'b', // 1
            'c', // 2
            'd', // 3
            'e', // 4
            'f', // 5
            'g', // 6
            'h', // 7
            'i', // 8
            'j', // 9
            'k', // 10
            'l', // 11
            'm', // 12
            'n', // 13
            'o', // 14
            'p', // 15
            'q', // 16
            'r', // 17
            's', // 18
            't', // 19
            'u', // 20
            'v', // 21
            'w', // 22
            'x', // 23
            'y', // 24
            'z'  // 25
    };

    private static Map<Character, Integer> NORM_CHAR_INDEXES = new HashMap<>();
    private static Map<Integer, Character> NORM_IDX_CHARS = new HashMap<>();

    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            NORM_CHAR_INDEXES.put(ALPHABET[i], i);
            NORM_IDX_CHARS.put(i, ALPHABET[i]);
        }
    }

    private static final int ALPHABET_LENGTH = ALPHABET.length;
    private static final int ALPHABET_MAX_IDX = ALPHABET.length - 1;

    public static String encode(String plainText, int shift) {

        char[] rv = plainText.toCharArray();
        for (int i = 0; i < rv.length; i++) {
            rv[i] = shiftChar(rv[i], shift);
        }

        return new String(rv);
    }

    public static String decode(String cipherText, int shift) {
        return encode(cipherText, -shift);
    }

    public static char shiftChar(char ch, int shift) {
        Integer idx = NORM_CHAR_INDEXES.get(ch);
        if (idx == null) {
            return ch;
        }

        return NORM_IDX_CHARS.get(shiftIdx(idx, shift));
    }

    public static int shiftIdx(int positionIdx, int shift) {
        assert positionIdx >= 0 : " positionIdx too small";
        assert positionIdx <= ALPHABET_MAX_IDX : " positionIdx too large";

        return (positionIdx + shift) % ALPHABET_LENGTH;
    }
}
