package com.zalizniak.cryptopals.set1;

import org.junit.Test;

/**
 * https://cryptopals.com/sets/1/challenges/3
 */
public class Challenge3_SingleByteXORCypher {

    char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    private static final int RADIX = 16;

    @Test
    public void test() {
        final String XORedHex = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
        final String XORed = hexToASCII(XORedHex);
        final String decrypted = "Cooking MC's like a pound of bacon";

        for (char aChar : CHARS) {
            String variant = singleCharacterXor(XORed, aChar);

            System.out.println(aChar + " --> " + variant);
            if (variant.equals(decrypted)) {
                break;
            }
        }
    }

    public static String hexToASCII(String hex) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for (int i = 0; i < hex.length() - 1; i += 2) {
            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char) decimal);
            temp.append(decimal);
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

}