package com.zalizniak.medium.stack;

import org.junit.Assert;
import org.junit.Test;

public class QueueOfTwoStacksTest {

    @Test
    public void test() {
        QueueOfTwoStacks queue = new QueueOfTwoStacks();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        Assert.assertEquals(1, queue.poll().intValue());
        Assert.assertEquals(2, queue.poll().intValue());
        Assert.assertEquals(3, queue.poll().intValue());

        queue.add(1);
        queue.add(2);

        Assert.assertEquals(1, queue.poll().intValue());
        Assert.assertEquals(2, queue.poll().intValue());
    }
}
