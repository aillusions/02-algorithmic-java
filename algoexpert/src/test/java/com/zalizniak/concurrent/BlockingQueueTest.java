package com.zalizniak.concurrent;

import org.junit.Test;

import java.util.concurrent.Executors;

public class BlockingQueueTest {

    @Test
    public void test() throws InterruptedException {
        final int count = 10;
        BlockingQueue queue = new BlockingQueue(count);

        Runnable runnable = () -> {
            for (int i = 0; i < count; i++) {
                try {
                    int j = queue.dequeue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Dequeued all");
        };
        Executors.newSingleThreadExecutor().submit(runnable);

        for (int i = 0; i < count; i++) {
            queue.enqueue(i);
            Thread.sleep(10);
        }

        System.out.println("Enqueued all");
    }

    @Test
    public void test2() throws InterruptedException {
        final int count = 1;

        BlockingQueue queue = new BlockingQueue(count);

        Runnable runnable = () -> {
            for (int i = 0; i < 2; i++) {
                try {
                    int j = queue.dequeue();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Dequeued all");
        };

        Executors.newSingleThreadExecutor().submit(runnable);

        queue.enqueue(0);
        queue.enqueue(1);

        System.out.println("Enqueued all");
        Thread.sleep(1000);
    }
}
