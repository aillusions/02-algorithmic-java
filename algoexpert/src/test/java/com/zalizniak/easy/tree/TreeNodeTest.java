package com.zalizniak.easy.tree;


import org.junit.Test;

public class TreeNodeTest {

    @Test
    public void shouldPrintTree() {

        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.add(n0);
        n2.add(n1, n3);
        n3.add(n4, n5);

        StringBuilder buffer = new StringBuilder();
        n2.print(buffer, "", "");
        System.out.println(buffer);
    }
}
