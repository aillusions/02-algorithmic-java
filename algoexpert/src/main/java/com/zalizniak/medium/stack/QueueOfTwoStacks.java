package com.zalizniak.medium.stack;

import java.util.Stack;

public class QueueOfTwoStacks {

    private Stack<Integer> inbox = new Stack<>();
    private Stack<Integer> outbox = new Stack<>();

    public void add(Integer integer) {
        inbox.push(integer);
    }

    public Integer poll() {
        while (!inbox.isEmpty()) {
            outbox.push(inbox.pop());
        }
        return outbox.pop();
    }

    public Integer peek() {
        return inbox.peek();
    }
}
