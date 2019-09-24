package com.zalizniak.concurrent;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private final Queue<Integer> queue = new LinkedList<>();

    private final int limit;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Integer item) throws InterruptedException {
        while (queue.size() >= limit) {
            System.out.println("Waiting for dequeue.");
            wait();
        }
        queue.add(item);
        System.out.println("Enqueued " + item);
        notifyAll();
    }

    public synchronized Integer dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Waiting for enqueue.");
            wait();
        }

        //  Retrieves and removes the head of this queue
        Integer rv = queue.poll();
        System.out.println("Dequeued " + rv);
        notifyAll();
        return rv;
    }
}
