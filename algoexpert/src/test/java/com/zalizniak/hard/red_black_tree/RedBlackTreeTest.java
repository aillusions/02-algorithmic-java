package com.zalizniak.hard.red_black_tree;

import org.junit.Test;

public class RedBlackTreeTest {

    @Test
    public void testNormal() {
        RedBlackTree tree = new RedBlackTree();
        tree.add(5);

        tree.add(7);
        tree.add(3);

        tree.add(4);
        tree.add(2);

        tree.add(9);

        tree.print();

        tree.delete(4);
        tree.print();

        tree.delete(3);
        tree.print();

        tree.delete(7);
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
