package com.zalizniak.bitwise;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class HexTest {

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
