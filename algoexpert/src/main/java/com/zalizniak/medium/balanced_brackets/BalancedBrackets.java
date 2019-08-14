package com.zalizniak.medium.balanced_brackets;

import java.util.Stack;

public class BalancedBrackets {

    private static final char OPEN = '[';
    private static final char CLOSE = ']';

    public static boolean isBalanced(String in) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < in.length(); i++) {
            char charAt = in.charAt(i);
            boolean open = (charAt == OPEN);
            if (open) {
                stack.push(1);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
