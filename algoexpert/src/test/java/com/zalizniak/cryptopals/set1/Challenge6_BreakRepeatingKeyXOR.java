package com.zalizniak.cryptopals.set1;

import com.zalizniak.Base64Test;
import com.zalizniak.BitwiseTest;
import com.zalizniak.ByteArraysTest;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * https://cryptopals.com/sets/1/challenges/6
 */
public class Challenge6_BreakRepeatingKeyXOR {

    public static final String UTF_8 = "UTF-8";
    public static final Charset UTF_8_CH = StandardCharsets.UTF_8;

    public static final String EXPECTED_KEY = "Terminator X: Bring the noise";

    @Test
    public void test1() {

        String cypherText = Base64Test.decodeString(BASE64_TEXT);
        byte[] cypherTextBytes = cypherText.getBytes(UTF_8_CH);
        int cypherTextLength = cypherTextBytes.length;
        System.out.println("cypherTextLength: " + cypherTextLength);

        int KEYSIZE = probableKeySize(cypherTextBytes);
        System.out.println("probableKeySize: " + KEYSIZE);
        Assert.assertEquals(EXPECTED_KEY.length(), KEYSIZE);

        byte[][] cipherTextBlocks = ByteArraysTest.splitOnBlocks(cypherTextBytes, KEYSIZE);
        //System.out.println("ciphertextBlocks: \n" + ByteArraysTest.printGrid(cipherTextBlocks));

        byte[][] transposedBlocks = transposeBlocks(cipherTextBlocks, KEYSIZE);
        //System.out.println("transposedBlocks: \n" + ByteArraysTest.printGrid(transposedBlocks));

        char[] keyChars = new char[KEYSIZE];
        for (int i = 0; i < transposedBlocks.length; i++) {
            byte[] transposedBlock = transposedBlocks[i];
            keyChars[i] = Challenge3_SingleByteXORCypher.singleByteXORCipher(new String(transposedBlock, UTF_8_CH));
        }

        String key = new String(keyChars);
        System.out.println("key: " + key);
        System.out.println();
        System.out.println();
        System.out.println();

        Assert.assertEquals(EXPECTED_KEY, key);

        //System.out.println(Challenge5_RepeatingKeyXOR.repeatingKeyXOR(cypherText, key));
    }

    public static byte[][] transposeBlocks(byte[][] cipherTextBlocks, int KEYSIZE) {
        byte[][] rv = new byte[KEYSIZE][cipherTextBlocks.length];

        for (int i = 0; i < KEYSIZE; i++) {
            for (int j = 0; j < cipherTextBlocks.length; j++) {
                rv[i][j] = cipherTextBlocks[j][i];
            }
        }

        return rv;
    }

    /**
     * The KEYSIZE with the smallest normalized edit distance is probably the key.
     * TODO You could proceed perhaps with the smallest 2-3 KEYSIZE values.
     * TODO Or take 4 KEYSIZE blocks instead of 2 and average the distances.
     */
    public static int probableKeySize(byte[] cypherTextBytes) {
        int minDistance = Integer.MAX_VALUE;
        int rv = 0;
        int pairs = 30;

        for (int KEYSIZE = 2; KEYSIZE < 40; KEYSIZE++) {
            int distance = 0;
            for (int i = 0; i < pairs; i++) {
                byte[] firstKEYSIZEWorthOfBytes = Arrays.copyOfRange(cypherTextBytes, KEYSIZE * i, KEYSIZE * (i + 1));
                byte[] secondKEYSIZEWorthOfBytes = Arrays.copyOfRange(cypherTextBytes, KEYSIZE * (i + 1), KEYSIZE * (i + 2));
                distance += BitwiseTest.editDistanceFast(firstKEYSIZEWorthOfBytes, secondKEYSIZEWorthOfBytes);
            }

            int normalizedDistance = distance / (KEYSIZE * pairs);
            if (normalizedDistance < minDistance) {
                minDistance = normalizedDistance;
                rv = KEYSIZE;
            }

            // System.out.println(KEYSIZE + " -> " + normalizedDistance);
        }

        return rv;
    }

    public static final String BASE64_TEXT = "" +
            "HUIfTQsPAh9PE048GmllH0kcDk4TAQsHThsBFkU2AB4BSWQgVB0dQzNTTmVS" +
            "BgBHVBwNRU0HBAxTEjwMHghJGgkRTxRMIRpHKwAFHUdZEQQJAGQmB1MANxYG" +
            "DBoXQR0BUlQwXwAgEwoFR08SSAhFTmU+Fgk4RQYFCBpGB08fWXh+amI2DB0P" +
            "QQ1IBlUaGwAdQnQEHgFJGgkRAlJ6f0kASDoAGhNJGk9FSA8dDVMEOgFSGQEL" +
            "QRMGAEwxX1NiFQYHCQdUCxdBFBZJeTM1CxsBBQ9GB08dTnhOSCdSBAcMRVhI" +
            "CEEATyBUCHQLHRlJAgAOFlwAUjBpZR9JAgJUAAELB04CEFMBJhAVTQIHAh9P" +
            "G054MGk2UgoBCVQGBwlTTgIQUwg7EAYFSQ8PEE87ADpfRyscSWQzT1QCEFMa" +
            "TwUWEXQMBk0PAg4DQ1JMPU4ALwtJDQhOFw0VVB1PDhxFXigLTRkBEgcKVVN4" +
            "Tk9iBgELR1MdDAAAFwoFHww6Ql5NLgFBIg4cSTRWQWI1Bk9HKn47CE8BGwFT" +
            "QjcEBx4MThUcDgYHKxpUKhdJGQZZVCFFVwcDBVMHMUV4LAcKQR0JUlk3TwAm" +
            "HQdJEwATARNFTg5JFwQ5C15NHQYEGk94dzBDADsdHE4UVBUaDE5JTwgHRTkA" +
            "Umc6AUETCgYAN1xGYlUKDxJTEUgsAA0ABwcXOwlSGQELQQcbE0c9GioWGgwc" +
            "AgcHSAtPTgsAABY9C1VNCAINGxgXRHgwaWUfSQcJABkRRU8ZAUkDDTUWF01j" +
            "OgkRTxVJKlZJJwFJHQYADUgRSAsWSR8KIgBSAAxOABoLUlQwW1RiGxpOCEtU" +
            "YiROCk8gUwY1C1IJCAACEU8QRSxORTBSHQYGTlQJC1lOBAAXRTpCUh0FDxhU" +
            "ZXhzLFtHJ1JbTkoNVDEAQU4bARZFOwsXTRAPRlQYE042WwAuGxoaAk5UHAoA" +
            "ZCYdVBZ0ChQLSQMYVAcXQTwaUy1SBQsTAAAAAAAMCggHRSQJExRJGgkGAAdH" +
            "MBoqER1JJ0dDFQZFRhsBAlMMIEUHHUkPDxBPH0EzXwArBkkdCFUaDEVHAQAN" +
            "U29lSEBAWk44G09fDXhxTi0RAk4ITlQbCk0LTx4cCjBFeCsGHEETAB1EeFZV" +
            "IRlFTi4AGAEORU4CEFMXPBwfCBpOAAAdHUMxVVUxUmM9ElARGgZBAg4PAQQz" +
            "DB4EGhoIFwoKUDFbTCsWBg0OTwEbRSonSARTBDpFFwsPCwIATxNOPBpUKhMd" +
            "Th5PAUgGQQBPCxYRdG87TQoPD1QbE0s9GkFiFAUXR0cdGgkADwENUwg1DhdN" +
            "AQsTVBgXVHYaKkg7TgNHTB0DAAA9DgQACjpFX0BJPQAZHB1OeE5PYjYMAg5M" +
            "FQBFKjoHDAEAcxZSAwZOBREBC0k2HQxiKwYbR0MVBkVUHBZJBwp0DRMDDk5r" +
            "NhoGACFVVWUeBU4MRREYRVQcFgAdQnQRHU0OCxVUAgsAK05ZLhdJZChWERpF" +
            "QQALSRwTMRdeTRkcABcbG0M9Gk0jGQwdR1ARGgNFDRtJeSchEVIDBhpBHQlS" +
            "WTdPBzAXSQ9HTBsJA0UcQUl5bw0KB0oFAkETCgYANlVXKhcbC0sAGgdFUAIO" +
            "ChZJdAsdTR0HDBFDUk43GkcrAAUdRyonBwpOTkJEUyo8RR8USSkOEENSSDdX" +
            "RSAdDRdLAA0HEAAeHQYRBDYJC00MDxVUZSFQOV1IJwYdB0dXHRwNAA9PGgMK" +
            "OwtTTSoBDBFPHU54W04mUhoPHgAdHEQAZGU/OjV6RSQMBwcNGA5SaTtfADsX" +
            "GUJHWREYSQAnSARTBjsIGwNOTgkVHRYANFNLJ1IIThVIHQYKAGQmBwcKLAwR" +
            "DB0HDxNPAU94Q083UhoaBkcTDRcAAgYCFkU1RQUEBwFBfjwdAChPTikBSR0T" +
            "TwRIEVIXBgcURTULFk0OBxMYTwFUN0oAIQAQBwkHVGIzQQAGBR8EdCwRCEkH" +
            "ElQcF0w0U05lUggAAwANBxAAHgoGAwkxRRMfDE4DARYbTn8aKmUxCBsURVQf" +
            "DVlOGwEWRTIXFwwCHUEVHRcAMlVDKRsHSUdMHQMAAC0dCAkcdCIeGAxOazkA" +
            "BEk2HQAjHA1OAFIbBxNJAEhJBxctDBwKSRoOVBwbTj8aQS4dBwlHKjUECQAa" +
            "BxscEDMNUhkBC0ETBxdULFUAJQAGARFJGk9FVAYGGlMNMRcXTRoBDxNPeG43" +
            "TQA7HRxJFUVUCQhBFAoNUwctRQYFDE43PT9SUDdJUydcSWRtcwANFVAHAU5T" +
            "FjtFGgwbCkEYBhlFeFsABRcbAwZOVCYEWgdPYyARNRcGAQwKQRYWUlQwXwAg" +
            "ExoLFAAcARFUBwFOUwImCgcDDU5rIAcXUj0dU2IcBk4TUh0YFUkASEkcC3QI" +
            "GwMMQkE9SB8AMk9TNlIOCxNUHQZCAAoAHh1FXjYCDBsFABkOBkk7FgALVQRO" +
            "D0EaDwxOSU8dGgI8EVIBAAUEVA5SRjlUQTYbCk5teRsdRVQcDhkDADBFHwhJ" +
            "AQ8XClJBNl4AC1IdBghVEwARABoHCAdFXjwdGEkDCBMHBgAwW1YnUgAaRyon" +
            "B0VTGgoZUwE7EhxNCAAFVAMXTjwaTSdSEAESUlQNBFJOZU5LXHQMHE0EF0EA" +
            "Bh9FeRp5LQdFTkAZREgMU04CEFMcMQQAQ0lkay0ABwcqXwA1FwgFAk4dBkIA" +
            "CA4aB0l0PD1MSQ8PEE87ADtbTmIGDAILAB0cRSo3ABwBRTYKFhROHUETCgZU" +
            "MVQHYhoGGksABwdJAB0ASTpFNwQcTRoDBBgDUkksGioRHUkKCE5THEVCC08E" +
            "EgF0BBwJSQoOGkgGADpfADETDU5tBzcJEFMLTx0bAHQJCx8ADRJUDRdMN1RH" +
            "YgYGTi5jMURFeQEaSRAEOkURDAUCQRkKUmQ5XgBIKwYbQFIRSBVJGgwBGgtz" +
            "RRNNDwcVWE8BT3hJVCcCSQwGQx9IBE4KTwwdASEXF01jIgQATwZIPRpXKwYK" +
            "BkdEGwsRTxxDSToGMUlSCQZOFRwKUkQ5VEMnUh0BR0MBGgAAZDwGUwY7CBdN" +
            "HB5BFwMdUz0aQSwWSQoITlMcRUILTxoCEDUXF01jNw4BTwVBNlRBYhAIGhNM" +
            "EUgIRU5CRFMkOhwGBAQLTVQOHFkvUkUwF0lkbXkbHUVUBgAcFA0gRQYFCBpB" +
            "PU8FQSsaVycTAkJHYhsRSQAXABxUFzFFFggICkEDHR1OPxoqER1JDQhNEUgK" +
            "TkJPDAUAJhwQAg0XQRUBFgArU04lUh0GDlNUGwpOCU9jeTY1HFJARE4xGA4L" +
            "ACxSQTZSDxsJSw1ICFUdBgpTNjUcXk0OAUEDBxtUPRpCLQtFTgBPVB8NSRoK" +
            "SREKLUUVAklkERgOCwAsUkE2Ug8bCUsNSAhVHQYKUyI7RQUFABoEVA0dWXQa" +
            "Ry1SHgYOVBFIB08XQ0kUCnRvPgwQTgUbGBwAOVREYhAGAQBJEUgETgpPGR8E" +
            "LUUGBQgaQRIaHEshGk03AQANR1QdBAkAFwAcUwE9AFxNY2QxGA4LACxSQTZS" +
            "DxsJSw1ICFUdBgpTJjsIF00GAE1ULB1NPRpPLF5JAgJUVAUAAAYKCAFFXjUe" +
            "DBBOFRwOBgA+T04pC0kDElMdC0VXBgYdFkU2CgtNEAEUVBwTWXhTVG5SGg8e" +
            "AB0cRSo+AwgKRSANExlJCBQaBAsANU9TKxFJL0dMHRwRTAtPBRwQMAAATQcB" +
            "FlRlIkw5QwA2GggaR0YBBg5ZTgIcAAw3SVIaAQcVEU8QTyEaYy0fDE4ITlhI" +
            "Jk8DCkkcC3hFMQIEC0EbAVIqCFZBO1IdBgZUVA4QTgUWSR4QJwwRTWM=";
}