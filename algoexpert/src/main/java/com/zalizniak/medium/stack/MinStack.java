package com.zalizniak.medium.stack;

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int x) {

        if (stack.isEmpty()) {
            stack.push(x);
            min.push(x);
        } else {
            stack.push(x);
            int y = min.peek();
            if (x < y) {
                min.push(x);
            } else {
                min.push(y);
            }
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
