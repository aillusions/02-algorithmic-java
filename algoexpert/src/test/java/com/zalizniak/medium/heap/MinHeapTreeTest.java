package com.zalizniak.medium.heap;

import org.junit.Test;

public class MinHeapTreeTest {

    @Test
    public void testInsert() {

        MinHeapTree minHeap = new MinHeapTree();

        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);
        //minHeap.insert(5);
        minHeap.insert(6);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(9);
        minHeap.insert(10);

        minHeap.print();

        minHeap.insert(5);

        minHeap.print();
    }

    @Test
    public void testDelete() {

    }
}
