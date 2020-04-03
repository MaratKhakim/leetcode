package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 03.04.2020.
 *
 * 208. Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */

class Trie {

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }

    private final TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            TrieNode child = curr.children.get(c);
            if(child == null) {
                child = new TrieNode();
                curr.children.put(c, child);
            }

            curr = child;
        }

        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            TrieNode child = curr.children.get(c);
            if(child == null) {
                return false;
            }

            curr = child;
        }

        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {
            TrieNode child = curr.children.get(c);
            if(child == null) {
                return false;
            }

            curr = child;
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
