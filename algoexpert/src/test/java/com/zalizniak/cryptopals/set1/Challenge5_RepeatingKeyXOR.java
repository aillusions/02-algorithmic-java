package com.zalizniak.cryptopals.set1;

import com.zalizniak.HexTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * https://cryptopals.com/sets/1/challenges/5
 * <p>
 * Vingenère Cipher
 */
public class Challenge5_RepeatingKeyXOR {

    @Test
    public void checkCircularList() {
        CircularCharList key = new CircularCharList("ICE");

        Assert.assertEquals('E', key.get(-2).charValue());
        Assert.assertEquals('C', key.get(-1).charValue());

        Assert.assertEquals('I', key.get(0).charValue());
        Assert.assertEquals('C', key.get(1).charValue());
        Assert.assertEquals('E', key.get(2).charValue());

        Assert.assertEquals('I', key.get(3).charValue());
        Assert.assertEquals('C', key.get(4).charValue());
        Assert.assertEquals('E', key.get(5).charValue());

        Assert.assertEquals('I', key.get(6).charValue());
        Assert.assertEquals('C', key.get(7).charValue());
        Assert.assertEquals('E', key.get(8).charValue());
    }

    @Test
    public void test1() {
        final String plain = "Burning 'em, if you ain't quick and nimble\n" // b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272a282b2f2043
                + "I go crazy when I hear a cymbal";

        String expectedHexed = "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f";
        String expectedXorred = HexTest.hexToASCII(expectedHexed);
        String expectedPlain = repeatingKeyXOR(expectedXorred);
        Assert.assertEquals(plain, expectedPlain);

        String xorred = repeatingKeyXOR(plain);
        Assert.assertEquals(expectedXorred, xorred);

        String hexed = HexTest.convertStringToHex(xorred);
        Assert.assertEquals(expectedHexed, hexed);
    }

    // In repeating-key XOR, you'll sequentially apply each byte of the key;
    // the first byte of plaintext will be XOR'd against I, the next C, the next E
    // then I again for the 4th byte, and so on.
    public static String repeatingKeyXOR(String in) {
        CircularCharList key = new CircularCharList("ICE");
        char[] rv = new char[in.length()];
        for (int i = 0; i < in.length(); i++) {
            rv[i] = (char) (in.charAt(i) ^ key.get(i));
        }

        return new String(rv);
    }

    private static class CircularCharList extends ArrayList<Character> {

        public CircularCharList(String str) {
            for (char c : str.toCharArray()) {
                add(c);
            }
        }

        @Override
        public Character get(int index) {
            int size = this.size();
            if (index < 0) {
                return super.get(-index);
            } else if (index >= size) {
                return super.get(index % size);
            }

            return super.get(index);
        }
    }
}