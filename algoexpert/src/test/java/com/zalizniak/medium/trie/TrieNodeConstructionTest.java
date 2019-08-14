package com.zalizniak.medium.trie;

import org.junit.Test;

public class TrieNodeConstructionTest {

    @Test
    public void test() {
        TrieNode root = new TrieNode();

        TrieNode node_2 = new TrieNode(false);
        root.nodes.put('C', node_2);

        TrieNode node_3 = new TrieNode(false);
        node_2.nodes.put('A', node_3);

        TrieNode node_4 = new TrieNode(true);
        node_3.nodes.put('R', node_4);
    }
}
