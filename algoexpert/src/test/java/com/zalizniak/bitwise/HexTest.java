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
        System.out.println(1 + " -> " + String.format("%02X", 1));
        System.out.println(5 + " -> " + String.format("%02X", 5));
        System.out.println(9 + " -> " + String.format("%02X", 9));
        System.out.println(10 + " -> " + String.format("%02X", 10));
        System.out.println(100 + " -> " + String.format("%02X", 100));
        System.out.println(255 + " -> " + String.format("%02X", 255));
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
