package com.zalizniak.medium.tree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {

    final Integer name;
    final List<TreeNode> children = new LinkedList<>();

    public TreeNode(Integer name) {
        this.name = name;
    }

    public void add(TreeNode... nodes) {
        children.addAll(Arrays.asList(nodes));
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    public void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(name);
        buffer.append('\n');
        for (Iterator<TreeNode> it = children.iterator(); it.hasNext(); ) {
            TreeNode next = it.next();
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }
}
