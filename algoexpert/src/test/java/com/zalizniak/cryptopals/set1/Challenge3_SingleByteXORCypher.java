package com.zalizniak.cryptopals.set1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://cryptopals.com/sets/1/challenges/3
 * <p>
 * http://en.algoritmy.net/article/40379/Letter-frequency-English
 * <p>
 * Letter	Frequency (%)
 * A	8.167%
 * B	1.492%
 * C	2.782%
 * D	4.253%
 * E	12.702%
 * F	2.228%
 * G	2.015%
 * H	6.094%
 * I	6.966%
 * J	0.153%
 * K	0.772%
 * L	4.025%
 * M	2.406%
 * N	6.749%
 * O	7.507%
 * P	1.929%
 * Q	0.095%
 * R	5.987%
 * S	6.327%
 * T	9.056%
 * U	2.758%
 * V	0.978%
 * W	2.360%
 * X	0.150%
 * Y	1.974%
 * Z	0.074%
 */
public class Challenge3_SingleByteXORCypher {

    //private static final char[] CHARS = "8".toCharArray();
    private static final char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    private static final Map<Character, Double> ENGLISH_FREQ = new HashMap<>();

    static {
        ENGLISH_FREQ.put('a', 0.08167);
        ENGLISH_FREQ.put('b', 0.01492);
        ENGLISH_FREQ.put('c', 0.02782);
        ENGLISH_FREQ.put('d', 0.04253);
        ENGLISH_FREQ.put('e', 0.12702);
        ENGLISH_FREQ.put('f', 0.02228);
        ENGLISH_FREQ.put('g', 0.02015); // A-G
        ENGLISH_FREQ.put('h', 0.06094);
        ENGLISH_FREQ.put('i', 0.06966);
        ENGLISH_FREQ.put('j', 0.00153);
        ENGLISH_FREQ.put('k', 0.00772);
        ENGLISH_FREQ.put('l', 0.04025);
        ENGLISH_FREQ.put('m', 0.02406);
        ENGLISH_FREQ.put('n', 0.06749); // H-N
        ENGLISH_FREQ.put('o', 0.07507);
        ENGLISH_FREQ.put('p', 0.01929);
        ENGLISH_FREQ.put('q', 0.00095);
        ENGLISH_FREQ.put('r', 0.05987);
        ENGLISH_FREQ.put('s', 0.06327);
        ENGLISH_FREQ.put('t', 0.09056);
        ENGLISH_FREQ.put('u', 0.02758); // O-U
        ENGLISH_FREQ.put('v', 0.00978);
        ENGLISH_FREQ.put('w', 0.02360);
        ENGLISH_FREQ.put('x', 0.00150);
        ENGLISH_FREQ.put('y', 0.01974);
        ENGLISH_FREQ.put('z', 0.00074); // V-Z
    }

    @Test
    public void test() {
        final String XORedHex = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
        final String XORed = hexToASCII(XORedHex);
        final String decrypted = "Cooking MC's like a pound of bacon";

        double minChi = Double.MAX_VALUE;
        String rv = "";

        for (char aChar : CHARS) {
            String variant = singleCharacterXor(XORed, aChar);
            double chi = getChi2(variant);
            if (chi < minChi) {
                minChi = chi;
                rv = variant;
            }

            System.out.println(aChar + " --> " + chi + " - " + variant);
        }

        System.out.println("selected: " + rv + " with Chi: " + minChi);
        Assert.assertEquals(decrypted, rv);
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

    public static double getChi2(String str) {

        str = str.toLowerCase();
        final Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 97 && c <= 122) { // lowercase a-z
                count.put(c, count.get(c) == null ? 1 : count.get(c) + 1);
            }
        }

        double chi2 = 0;
        for (Character character : ENGLISH_FREQ.keySet()) {
            int observed = count.getOrDefault(character, 0);
            double expected = str.length() * ENGLISH_FREQ.get(character);
            double difference = observed - expected;
            chi2 += difference * difference / expected;
        }
        return chi2;
    }
}