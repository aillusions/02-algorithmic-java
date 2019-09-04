package com.zalizniak.cryptopals.set1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://cryptopals.com/sets/1/challenges/3
 * <p>
 * http://pi.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html
 * <p>
 * // Letter	Count	 	Frequency
 * // e	        21912	 	12.02
 * // t	        16587	 	9.10
 * // a	        14810	 	8.12
 * // o	        14003	 	7.68
 * // i	        13318	 	7.31
 * // n	        12666	 	6.95
 * // s	        11450	 	6.28
 * // r	        10977	 	6.02
 * // h	        10795	 	5.92
 * // d	        7874	 	4.32
 * // l	        7253	 	3.98
 * // u	        5246	 	2.88
 * // c	        4943	 	2.71
 * // m	        4761	 	2.61
 * // f	        4200	 	2.30
 * // y	        3853	 	2.11
 * // w	        3819	 	2.09
 * // g	        3693	 	2.03
 * // p	        3316	 	1.82
 * // b	        2715	 	1.49
 * // v	        2019	 	1.11
 * // k	        1257	 	0.69
 * // x	        315	 		0.17
 * // q	        205	 		0.11
 * // j	        188	 		0.10
 * // z	        128	 		0.07
 * <p>
 * // SUM:      182,303     99.99
 */
public class Challenge3_SingleByteXORCypher {

    //private static final char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final char[] CHARS = "8X".toCharArray();

    private static final Map<Character, Double> ENGLISH_FREQ = new HashMap<>();

    static {
        ENGLISH_FREQ.put('e', 12.02);
        ENGLISH_FREQ.put('t', 9.10);
        ENGLISH_FREQ.put('a', 8.12);
        ENGLISH_FREQ.put('o', 7.68);
        ENGLISH_FREQ.put('i', 7.31);
        ENGLISH_FREQ.put('n', 6.95);
        ENGLISH_FREQ.put('s', 6.28);
        ENGLISH_FREQ.put('r', 6.02);
        ENGLISH_FREQ.put('h', 5.92);
        ENGLISH_FREQ.put('d', 4.32);
        ENGLISH_FREQ.put('l', 3.98);
        ENGLISH_FREQ.put('u', 2.88);
        ENGLISH_FREQ.put('c', 2.71);
        ENGLISH_FREQ.put('m', 2.61);
        ENGLISH_FREQ.put('f', 2.30);
        ENGLISH_FREQ.put('y', 2.11);
        ENGLISH_FREQ.put('w', 2.09);
        ENGLISH_FREQ.put('g', 2.03);
        ENGLISH_FREQ.put('p', 1.82);
        ENGLISH_FREQ.put('b', 1.49);
        ENGLISH_FREQ.put('v', 1.11);
        ENGLISH_FREQ.put('k', 0.69);
        ENGLISH_FREQ.put('x', 0.17);
        ENGLISH_FREQ.put('q', 0.11);
        ENGLISH_FREQ.put('j', 0.10);
        ENGLISH_FREQ.put('z', 0.07);
    }

    @Test
    public void checkLettersFreq() {
        double sum = 0;
        for (Character character : ENGLISH_FREQ.keySet()) {
            sum += ENGLISH_FREQ.get(character);
        }

        System.out.println("Char freq: " + (sum));
    }

    @Test
    public void test() {
        final String XORedHex = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
        final String XORed = hexToASCII(XORedHex);
        final String decrypted = "Cooking MC's like a pound of bacon";

        String rv = singleBbyteXORCipher(XORed);

        System.out.println("selected: " + rv);
        Assert.assertEquals(decrypted, rv);
    }

    public static String singleBbyteXORCipher(String XORed) {
        double minChi = Double.MAX_VALUE;
        String rv = "";

        for (char aChar : CHARS) {
            String variant = singleCharacterXor(XORed, aChar);
            double chi = getEnglishScore(variant);
            if (chi < minChi) {
                minChi = chi;
                rv = variant;
            }

            System.out.println(aChar + " --> " + chi + " - " + variant);
        }

        return rv;
    }

    public static String hexToASCII(String hex) {
        StringBuilder sb = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for (int i = 0; i < hex.length() - 1; i += 2) {
            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char) decimal);
        }

        return sb.toString();
    }

    public static String singleCharacterXor(String hex, char character) {
        char[] rv = new char[hex.length()];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = (char) (hex.charAt(i) ^ character);
        }
        return new String(rv);
    }

    public static double getEnglishScore(String str) {
        str = str.toLowerCase();
        int length = str.length();

        final Map<Character, Integer> count = countChars(str);

        double rv = 0;
        for (Character character : ENGLISH_FREQ.keySet()) {
            double observed = count.getOrDefault(character, 0);
            double expected = length * (ENGLISH_FREQ.get(character) / 100);

            double difference = Math.abs(observed - expected);
            double chi = Math.pow(difference, 2) / expected;
            rv += chi;
        }
        return rv;
    }

    public static Map<Character, Integer> countChars(String str) {
        int length = str.length();
        final Map<Character, Integer> rv = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (ENGLISH_FREQ.get(c) != null) {
                rv.put(c, rv.get(c) == null ? 1 : rv.get(c) + 1);
            }
        }

        return rv;
    }
}