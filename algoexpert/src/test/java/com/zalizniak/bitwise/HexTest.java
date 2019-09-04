package com.zalizniak.bitwise;

import org.junit.Test;

import java.math.BigDecimal;
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
        System.out.println(100 + " -> " + String.format("%02x", 100));
        System.out.println(255 + " -> " + String.format("%02x", 255));
    }

    @Test
    public void testChar() {
        System.out.println(-1 + " -> " + String.format("%04x", -1));
        System.out.println(1 + " -> " + String.format("%04x", 1));
        System.out.println(100 + " -> " + String.format("%04x", 100));
        System.out.println((int) '\uffff' + " -> " + String.format("%04x", (int) '\uffff'));
        System.out.println('a' + " -> " + Integer.toHexString((int) 'a'));
    }

    @Test
    public void testInt() {
        System.out.println(-300 + " -> " + Integer.toHexString(-1));
        System.out.println(500 + " -> " + Integer.toHexString(500));
        System.out.println(100_000_000 + " -> " + Integer.toHexString(100_000_000));
    }

    @Test
    public void testLong() {
        System.out.println(500L + " -> " + Long.toHexString(500L));
        System.out.println(100_000_000L + " -> " + Long.toHexString(100_000_000L));
        System.out.println(1_000_000_000_000_000L + " -> " + Long.toHexString(1_000_000_000_000_000L));
    }

    @Test
    public void testBigDecimal() {
        System.out.println(100 + " -> " + new BigInteger("100").toString(16));
        System.out.println("1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000" + " -> "
                + new BigInteger("1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000".replace("_", "")).toString(16));
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
        return String.format("%040x", new BigInteger(1, str.getBytes(StandardCharsets.UTF_8)));
    }
}
