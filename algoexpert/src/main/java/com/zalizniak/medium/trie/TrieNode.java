package com.zalizniak.medium.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public TrieNode() {

    }

    public TrieNode(boolean isWord) {
        this.isWord = isWord;
    }

    public boolean isWord;
    public final Map<Character, TrieNode> nodes = new HashMap<>();
}
