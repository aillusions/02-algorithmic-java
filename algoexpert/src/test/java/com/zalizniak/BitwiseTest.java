package com.zalizniak;

import com.zalizniak.cryptopals.set1.Challenge6_BreakRepeatingKeyXOR;
import com.zalizniak.medium.levenshtein_distance.MyLevenshteinDistance;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BitwiseTest {

    @Test
    public void testEditDistance() {
        String strA = "this is a test";
        String strB = "wokka wokka!!!";

        Assert.assertEquals(37, BitwiseTest.editDistanceSlow(strA, strB));
        Assert.assertEquals(37, BitwiseTest.editDistanceFast(strA, strB));
        Assert.assertEquals(37, BitwiseTest.editDistanceFast2(strA, strB));
    }

    public static int bitsMismatch(byte byte1, byte byte2) {
        int rv = 0;
        for (int i = 0; i < 8; i++) {
            // right shift both the numbers by 'i' and
            // check if the bit at the 0th position is different
            if (((byte1 >> i) & 1) != ((byte2 >> i) & 1)) {
                rv++;
            }
        }

        return rv;
    }

    public static int editDistanceSlow(String str1, String str2) {
        String binaryString1 = convertToBinary(str1, Challenge6_BreakRepeatingKeyXOR.UTF_8);
        String binaryString2 = convertToBinary(str2, Challenge6_BreakRepeatingKeyXOR.UTF_8);
        System.out.println(str1 + " -> " + binaryString1);
        System.out.println(str2 + " -> " + binaryString2);

        return new MyLevenshteinDistance().getDistance(binaryString1, binaryString2);
    }

    /**
     * The Hamming distance between two strings of equal length is the number of positions at which the corresponding symbols are different.
     * In other words, it is the number of substitutions required to transform one string into another.
     */
    public static int editDistanceFast(String str1, String str2) {
        byte[] bytes1 = str1.getBytes(Challenge6_BreakRepeatingKeyXOR.UTF_8_CH);
        byte[] bytes2 = str2.getBytes(Challenge6_BreakRepeatingKeyXOR.UTF_8_CH);

        int rv = 0;
        for (int i = 0; i < bytes1.length; i++) {
            byte byte1 = bytes1[i];
            byte byte2 = bytes2[i];
            byte xorred = (byte) (byte1 ^ byte2);

            while (xorred != 0) {
                rv += xorred & 1;
                xorred >>= 1;
            }
        }

        return rv;
    }

    public static String xor(String strA, String strB) {
        char[] rv = new char[strA.length()];
        for (int i = 0; i < strA.length(); i++) {
            rv[i] = (char) (strA.charAt(i) ^ strB.charAt(i));
        }

        return new String(rv);
    }

    public static int editDistanceFast2(String str1, String str2) {
        byte[] bytes1 = str1.getBytes(Challenge6_BreakRepeatingKeyXOR.UTF_8_CH);
        byte[] bytes2 = str2.getBytes(Challenge6_BreakRepeatingKeyXOR.UTF_8_CH);

        int rv = 0;
        for (int i = 0; i < bytes1.length; i++) {
            rv += bitsMismatch(bytes1[i], bytes2[i]);
        }

        return rv;
    }

    // there are 26 letters in English: to represent all letters enough 5 bits (2 ^ 5 == 32)

    @Test
    public void testBitwiseOperations() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + " -> " + (i << 1));
        }
    }

    @Test
    public void binaryString() throws UnsupportedEncodingException {
        System.out.println("0" + " -> " + Integer.toBinaryString(0));
        System.out.println("1" + " -> " + Integer.toBinaryString(1));
        System.out.println("1000" + " -> " + Integer.toBinaryString(1000));

        System.out.println("a" + " -> " + convertToBinary("a", "UTF-32"));

        System.out.println("a" + " -> " + convertToBinary("a", "UTF-8"));
        System.out.println("aa" + " -> " + convertToBinary("aa", "UTF-8"));
        System.out.println("aaa" + " -> " + convertToBinary("aaa", "UTF-8"));
        System.out.println("aaa" + " -> " + convertToBinary("語", "UTF-8"));

        Assert.assertEquals("10101011", convertToBinary("T", "UTF-8"));
    }

    public static String convertToBinary(String input, String encoding) {

        byte[] encoded_input = Charset.forName(encoding)
                .encode(input)
                .array();

        return IntStream.range(0, encoded_input.length)
                .map(i -> encoded_input[i])
                .mapToObj(e -> Integer.toBinaryString(e ^ 255))
                .map(e -> String.format("%1$" + Byte.SIZE + "s", e).replace(" ", "0"))
                .collect(Collectors.joining(" "));
    }
}
