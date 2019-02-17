package com.zalizniak.numbermanipulations;

public class ReverseNumber {

    public static boolean palindrome(int num) {
        return reverse(num) == num;
    }

    public static int reverse(int num) {
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return reversed;
    }
}
