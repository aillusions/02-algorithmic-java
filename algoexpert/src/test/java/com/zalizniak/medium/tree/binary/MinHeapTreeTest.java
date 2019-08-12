package com.zalizniak.medium.tree.binary;

import org.junit.Test;

public class MinHeapTreeTest {

    @Test
    public void test() {
        MinHeapTree minHeap = new MinHeapTree();

        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(5);
        minHeap.insert(6);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(9);
        minHeap.insert(10);

        minHeap.print();
    }
}
