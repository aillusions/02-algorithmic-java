package com.zalizniak.hard.red_black_tree;

import org.junit.Test;

public class RedBlackTreeTest {

    @Test
    public void testNormal() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(0);
        tree.add(1);
        tree.add(-1);

        tree.print();
    }

    @Test
    public void testUnbalanced() {
        RedBlackTree tree = new RedBlackTree();

        for (int i = 0; i <= 5; i++) {
            tree.add(i);
        }

        tree.print();
    }
}
