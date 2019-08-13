package com.zalizniak.medium.stack;

import org.junit.Assert;
import org.junit.Test;

public class MinStackTest {

    @Test
    public void test() {
        MinStack stack = new MinStack();

        stack.push(10);
        stack.push(20);
        stack.push(2);
        stack.push(30);
        stack.push(1);
        stack.push(40);

        Assert.assertEquals(1, stack.getMin());

        stack.pop();
        stack.pop();

        Assert.assertEquals(2, stack.getMin());

        stack.pop();
        stack.pop();

        Assert.assertEquals(10, stack.getMin());
    }
}
