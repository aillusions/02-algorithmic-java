package com.zalizniak.cryptopals.set2;

import com.zalizniak.Base64Test;
import com.zalizniak.ByteArraysTest;
import com.zalizniak.cryptopals.set1.Challenge2_XOR;
import com.zalizniak.cryptopals.set1.Challenge7_AESinECB;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Cipher Block Chaining (CBC)
 */
public class Challenge10_ImplementCBCmode {

    // The first plaintext block, which has no associated previous ciphertext block,
    // is added to a "fake 0th ciphertext block"
    // called the initialization vector, or IV.
    public static final byte[] IV = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static final String KEY_TEXT = "YELLOW SUBMARINE";
    public static final byte[] KEY = KEY_TEXT.getBytes(StandardCharsets.UTF_8);

    @Test
    public void testDecryptAssignment() {
        byte[] cypherText = Base64Test.decode(BASE64_TEXT);
        byte[] plainText = decryptCBC(cypherText, KEY);
        System.out.println(new String(plainText, StandardCharsets.UTF_8));
    }

    @Test
    public void testDecrypt() {
        Assert.assertEquals("test", new String(decryptCBC(encryptCBC("test".getBytes(StandardCharsets.UTF_8), KEY), KEY), StandardCharsets.UTF_8));
    }


    @Test
    public void testEncrypt() {
        System.out.println(Arrays.toString(encryptCBC("test".getBytes(StandardCharsets.UTF_8), KEY)));
        System.out.println(Arrays.toString(encryptCBC("test-test-test-test-test-test-test-test-test-test-test-test".getBytes(StandardCharsets.UTF_8), KEY)));
    }

    public static byte[] decryptCBC(byte[] cypherText, byte[] key) {
        byte[][] blocks = ByteArraysTest.splitOnBlocks(cypherText, Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES);

        int paddingLength = 0;
        byte[] rvCandidate = new byte[cypherText.length]; // TODO refine also remove pad bytes

        byte[] previousBlock = IV;
        for (int i = 0; i < blocks.length; i++) {
            byte[] cypherBlock = blocks[i];
            byte[] prePlainBlock = Challenge7_AESinECB.decryptECBNoPad(cypherBlock, key);
            byte[] plainBlock = Challenge2_XOR.fixedXOR(previousBlock, prePlainBlock);
            previousBlock = cypherBlock;

            System.arraycopy(plainBlock, 0, rvCandidate, i * Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES, plainBlock.length);

            if (i == blocks.length - 1) {
                byte lastByte = plainBlock[Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES - 1];
                if (lastByte < Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES) {
                    boolean paddingDetected = false;
                    int startFromIdx = Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES - 1;
                    int endByIdx = Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES - lastByte;
                    for (int j = startFromIdx; j >= endByIdx; j--) {
                        if (plainBlock[j] != lastByte) {
                            paddingDetected = false;
                            break;
                        } else {
                            paddingDetected = true;
                        }
                    }
                    if (paddingDetected) {
                        paddingLength = lastByte;
                    }
                }
            }
        }

        byte[] rv;
        if (paddingLength > 0) {
            rv = new byte[cypherText.length - paddingLength];
            System.arraycopy(rvCandidate, 0, rv, 0, rv.length);
        } else {
            rv = rvCandidate;
        }


        return rv;
    }

    public static byte[] encryptCBC(byte[] plainText, byte[] key) {
        return encryptCBC(IV, plainText, key);
    }

    public static byte[] encryptCBC(byte[] iv, byte[] plainText, byte[] key) {
        byte[][] blocks = ByteArraysTest.splitOnBlocks(plainText, Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES);
        byte[] rv = new byte[blocks.length * Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES];

        byte[] previousBlock = iv;
        for (int i = 0; i < blocks.length; i++) {
            byte[] block = blocks[i];
            block = Challenge2_XOR.fixedXOR(previousBlock, block);
            byte[] cypherBlock = Challenge7_AESinECB.encryptECBNoPad(block, key);
            previousBlock = cypherBlock;

            System.arraycopy(cypherBlock, 0, rv, i * Challenge7_AESinECB.AES_BLOCK_SIZE_BYTES, block.length);
        }

        return rv;
    }

    public static final String BASE64_TEXT = "" +
            "CRIwqt4+szDbqkNY+I0qbNXPg1XLaCM5etQ5Bt9DRFV/xIN2k8Go7jtArLIy" +
            "P605b071DL8C+FPYSHOXPkMMMFPAKm+Nsu0nCBMQVt9mlluHbVE/yl6VaBCj" +
            "NuOGvHZ9WYvt51uR/lklZZ0ObqD5UaC1rupZwCEK4pIWf6JQ4pTyPjyiPtKX" +
            "g54FNQvbVIHeotUG2kHEvHGS/w2Tt4E42xEwVfi29J3yp0O/TcL7aoRZIcJj" +
            "MV4qxY/uvZLGsjo1/IyhtQp3vY0nSzJjGgaLYXpvRn8TaAcEtH3cqZenBoox" +
            "BH3MxNjD/TVf3NastEWGnqeGp+0D9bQx/3L0+xTf+k2VjBDrV9HPXNELRgPN" +
            "0MlNo79p2gEwWjfTbx2KbF6htgsbGgCMZ6/iCshy3R8/abxkl8eK/VfCGfA6" +
            "bQQkqs91bgsT0RgxXSWzjjvh4eXTSl8xYoMDCGa2opN/b6Q2MdfvW7rEvp5m" +
            "wJOfQFDtkv4M5cFEO3sjmU9MReRnCpvalG3ark0XC589rm+42jC4/oFWUdwv" +
            "kzGkSeoabAJdEJCifhvtGosYgvQDARUoNTQAO1+CbnwdKnA/WbQ59S9MU61Q" +
            "KcYSuk+jK5nAMDot2dPmvxZIeqbB6ax1IH0cdVx7qB/Z2FlJ/U927xGmC/RU" +
            "FwoXQDRqL05L22wEiF85HKx2XRVB0F7keglwX/kl4gga5rk3YrZ7VbInPpxU" +
            "zgEaE4+BDoEqbv/rYMuaeOuBIkVchmzXwlpPORwbN0/RUL89xwOJKCQQZM8B" +
            "1YsYOqeL3HGxKfpFo7kmArXSRKRHToXuBgDq07KS/jxaS1a1Paz/tvYHjLxw" +
            "Y0Ot3kS+cnBeq/FGSNL/fFV3J2a8eVvydsKat3XZS3WKcNNjY2ZEY1rHgcGL" +
            "5bhVHs67bxb/IGQleyY+EwLuv5eUwS3wljJkGcWeFhlqxNXQ6NDTzRNlBS0W" +
            "4CkNiDBMegCcOlPKC2ZLGw2ejgr2utoNfmRtehr+3LAhLMVjLyPSRQ/zDhHj" +
            "Xu+Kmt4elmTmqLgAUskiOiLYpr0zI7Pb4xsEkcxRFX9rKy5WV7NhJ1lR7BKy" +
            "alO94jWIL4kJmh4GoUEhO+vDCNtW49PEgQkundV8vmzxKarUHZ0xr4feL1ZJ" +
            "THinyUs/KUAJAZSAQ1Zx/S4dNj1HuchZzDDm/nE/Y3DeDhhNUwpggmesLDxF" +
            "tqJJ/BRn8cgwM6/SMFDWUnhkX/t8qJrHphcxBjAmIdIWxDi2d78LA6xhEPUw" +
            "NdPPhUrJcu5hvhDVXcceZLa+rJEmn4aftHm6/Q06WH7dq4RaaJePP6WHvQDp" +
            "zZJOIMSEisApfh3QvHqdbiybZdyErz+yXjPXlKWG90kOz6fx+GbvGcHqibb/" +
            "HUfcDosYA7lY4xY17llY5sibvWM91ohFN5jyDlHtngi7nWQgFcDNfSh77TDT" +
            "zltUp9NnSJSgNOOwoSSNWadm6+AgbXfQNX6oJFaU4LQiAsRNa7vX/9jRfi65" +
            "5uvujM4ob199CZVxEls10UI9pIemAQQ8z/3rgQ3eyL+fViyztUPg/2IvxOHv" +
            "eexE4owH4Fo/bRlhZK0mYIamVxsRADBuBlGqx1b0OuF4AoZZgUM4d8v3iyUu" +
            "feh0QQqOkvJK/svkYHn3mf4JlUb2MTgtRQNYdZKDRgF3Q0IJaZuMyPWFsSNT" +
            "YauWjMVqnj0AEDHh6QUMF8bXLM0jGwANP+r4yPdKJNsoZMpuVoUBJYWnDTV+" +
            "8Ive6ZgBi4EEbPbMLXuqDMpDi4XcLE0UUPJ8VnmO5fAHMQkA64esY2QqldZ+" +
            "5gEhjigueZjEf0917/X53ZYWJIRiICnmYPoM0GSYJRE0k3ycdlzZzljIGk+P" +
            "Q7WgeJhthisEBDbgTuppqKNXLbNZZG/VaTdbpW1ylBv0eqamFOmyrTyh1APS" +
            "Gn37comTI3fmN6/wmVnmV4/FblvVwLuDvGgSCGPOF8i6FVfKvdESs+yr+1AE" +
            "DJXfp6h0eNEUsM3gXaJCknGhnt3awtg1fSUiwpYfDKZxwpPOYUuer8Wi+VCD" +
            "sWsUpkMxhhRqOBKaQaBDQG+kVJu6aPFlnSPQQTi1hxLwi0l0Rr38xkr+lHU7" +
            "ix8LeJVgNsQdtxbovE3i7z3ZcTFY7uJkI9j9E0muDN9x8y/YN25rm6zULYaO" +
            "jUoP/7FQZsSgxPIUvUiXkEq+FU2h0FqAC7H18cr3Za5x5dpw5nwawMArKoqG" +
            "9qlhqc34lXV0ZYwULu58EImFIS8+kITFuu7jOeSXbBgbhx8zGPqavRXeiu0t" +
            "bJd0gWs+YgMLzXtQIbQuVZENMxJSZB4aw5lPA4vr1fFBsiU4unjOEo/XAgwr" +
            "Tc0w0UndJFPvXRr3Ir5rFoIEOdRo+6os5DSlk82SBnUjwbje7BWsxWMkVhYO" +
            "6bOGUm4VxcKWXu2jU66TxQVIHy7WHktMjioVlWJdZC5Hq0g1LHg1nWSmjPY2" +
            "c/odZqN+dBBC51dCt4oi5UKmKtU5gjZsRSTcTlfhGUd6DY4Tp3CZhHjQRH4l" +
            "Zhg0bF/ooPTxIjLKK4r0+yR0lyRjqIYEY27HJMhZDXFDxBQQ1UkUIhAvXacD" +
            "WB2pb3YyeSQjt8j/WSbQY6TzdLq8SreZiuMWcXmQk4EH3xu8bPsHlcvRI+B3" +
            "gxKeLnwrVJqVLkf3m2cSGnWQhSLGbnAtgQPA6z7u3gGbBmRtP0KnAHWSK7q6" +
            "onMoYTH+b5iFjCiVRqzUBVzRRKjAL4rcL2nYeV6Ec3PlnboRzJwZIjD6i7WC" +
            "dcxERr4WVOjOBX4fhhKUiVvlmlcu8CkIiSnZENHZCpI41ypoVqVarHpqh2aP" +
            "/PS624yfxx2N3C2ci7VIuH3DcSYcaTXEKhz/PRLJXkRgVlWxn7QuaJJzDvpB" +
            "oFndoRu1+XCsup/AtkLidsSXMFTo/2Ka739+BgYDuRt1mE9EyuYyCMoxO/27" +
            "sn1QWMMd1jtcv8Ze42MaM4y/PhAMp2RfCoVZALUS2K7XrOLl3s9LDFOdSrfD" +
            "8GeMciBbfLGoXDvv5Oqq0S/OvjdID94UMcadpnSNsist/kcJJV0wtRGfALG2" +
            "+UKYzEj/2TOiN75UlRvA5XgwfqajOvmIIXybbdhxpjnSB04X3iY82TNSYTmL" +
            "LAzZlX2vmV9IKRRimZ2SpzNpvLKeB8lDhIyGzGXdiynQjFMNcVjZlmWHsH7e" +
            "ItAKWmCwNkeuAfFwir4TTGrgG1pMje7XA7kMT821cYbLSiPAwtlC0wm77F0T" +
            "a7jdMrLjMO29+1958CEzWPdzdfqKzlfBzsba0+dS6mcW/YTHaB4bDyXechZB" +
            "k/35fUg+4geMj6PBTqLNNWXBX93dFC7fNyda+Lt9cVJnlhIi/61fr0KzxOeX" +
            "NKgePKOC3Rz+fWw7Bm58FlYTgRgN63yFWSKl4sMfzihaQq0R8NMQIOjzuMl3" +
            "Ie5ozSa+y9g4z52RRc69l4n4qzf0aErV/BEe7FrzRyWh4PkDj5wy5ECaRbfO" +
            "7rbs1EHlshFvXfGlLdEfP2kKpT9U32NKZ4h+Gr9ymqZ6isb1KfNov1rw0KSq" +
            "YNP+EyWCyLRJ3EcOYdvVwVb+vIiyzxnRdugB3vNzaNljHG5ypEJQaTLphIQn" +
            "lP02xcBpMNJN69bijVtnASN/TLV5ocYvtnWPTBKu3OyOkcflMaHCEUgHPW0f" +
            "mGfld4i9Tu35zrKvTDzfxkJX7+KJ72d/V+ksNKWvwn/wvMOZsa2EEOfdCidm" +
            "oql027IS5XvSHynQtvFmw0HTk9UXt8HdVNTqcdy/jUFmXpXNP2Wvn8PrU2Dh" +
            "kkIzWhQ5Rxd/vnM2QQr9Cxa2J9GXEV3kGDiZV90+PCDSVGY4VgF8y7GedI1h";
}
