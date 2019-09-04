package com.zalizniak.bitwise;

import org.junit.Test;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class HexTest {

    /**
     * 2 ^ 8 == 16 ^ 2
     */
    @Test
    public void testByte() {
        System.out.println(1 + " -> " + String.format("%02x", 1));
        System.out.println(5 + " -> " + String.format("%02x", 5));
        System.out.println(9 + " -> " + String.format("%02x", 9));
        System.out.println(10 + " -> " + String.format("%02x", 10));
        System.out.println(15 + " -> " + String.format("%02x", 15));
        System.out.println(100 + " -> " + String.format("%02x", 100));
        System.out.println(255 + " -> " + String.format("%02x", 255));
    }

    @Test
    public void testChar() {
        System.out.println(-1 + " -> " + String.format("%04x", -1));
        System.out.println(1 + " -> " + String.format("%04x", 1));
        System.out.println(15 + " -> " + String.format("%04x", 15));
        System.out.println(100 + " -> " + String.format("%04x", 100));
        System.out.println((int) '\uffff' + " -> " + String.format("%04x", (int) '\uffff'));
        System.out.println('a' + " -> " + Integer.toHexString((int) 'a'));
    }

    @Test
    public void testInt() {
        System.out.println(-300 + " -> " + Integer.toHexString(-1));
        System.out.println(15 + " -> " + Integer.toHexString(15));
        System.out.println(500 + " -> " + Integer.toHexString(500));
        System.out.println(100_000_000 + " -> " + Integer.toHexString(100_000_000));
    }

    @Test
    public void testLong() {
        System.out.println(500L + " -> " + Long.toHexString(500L));
        System.out.println(15L + " -> " + Long.toHexString(15L));
        System.out.println(100_000_000L + " -> " + Long.toHexString(100_000_000L));
        System.out.println(1_000_000_000_000_000L + " -> " + Long.toHexString(1_000_000_000_000_000L));
    }

    @Test
    public void testBigDecimal() {
        System.out.println(100 + " -> " + new BigInteger("100").toString(16));
        System.out.println("1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000" + " -> "
                + new BigInteger("1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000".replace("_", "")).toString(16));

        System.out.println(255 + " -> " + new BigInteger("ff", 16).toString(16));
        System.out.println(15 + " -> " + new BigInteger("15").toString(16));
    }

    @Test
    public void testString() {
        System.out.println("" + " -> " + convertStringToHex(""));
        System.out.println("0" + " -> " + convertStringToHex("0"));
        System.out.println("1" + " -> " + convertStringToHex("1"));
        System.out.println("a" + " -> " + convertStringToHex("a"));
        System.out.println("aaaaa" + " -> " + convertStringToHex("aaaaa"));
        System.out.println("x" + " -> " + convertStringToHex("x"));
        System.out.println("[" + " -> " + convertStringToHex("["));
        System.out.println("\u00ff" + " -> " + convertStringToHex("\u00ff"));
        System.out.println("\uffff" + " -> " + convertStringToHex("\uffff"));
        System.out.println("ъ" + " -> " + convertStringToHex("ъ"));
        System.out.println("long text " + " -> " + convertStringToHex(LONG_TEXT));
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

    public static String convertStringToHex(String str) {
        return String.format("%x", new BigInteger(1, str.getBytes(StandardCharsets.UTF_8)));
    }

    public static final String LONG_TEXT = "What is a Hexadecimal?\n" +
            "Most people are familiar with the decimal, or base-10, system of numbers (all possible numbers can be notated using the 10 digits, 0,1,2,3,4,5,6,7,8,9). With only 10 digits, extra digits need to be used at certain intervals to correctly notate a number. For example, the number 423,004 uses twice as much digits as the number 961.\n" +
            "\n" +
            "The hexadecimal, or base-16, system was created to emulate some of the same properties of the common decimal system. The overall difference is, 16 digits are available instead of the 10 digits available to use to notate the value of a number.\n" +
            "\n" +
            "The 16 symbols that the hexadecimal system uses are: 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E and F. So instead of a decimal symbol of 10, hexadecimal uses an A, and so on and so forth until we get to the decimal of 15 which is notated as F. Similar to the decimal system, after the base of 16 symbols has been used, the appropriate extra digit is added and the order of numbers starts over. In other words, after F, we begin with 10, and so on. To better understand the relationship between the Decimal and Hexadecimal system, check out the table below.";
}
