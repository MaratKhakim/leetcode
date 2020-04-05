package trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Date 05.04.2020.
 *
 * 677. Map Sum Pairs
 *
 * Implement a MapSum class with insert, and sum methods.
 *
 * For the method insert, you'll be given a pair of (string, integer).
 * The string represents the key and the integer represents the value.
 * If the key already existed, then the original key-value pair will be overridden to the new one.
 *
 * For the method sum, you'll be given a string representing the prefix,
 * and you need to return the sum of all the pairs' value whose key starts with the prefix.
 *
 * https://leetcode.com/problems/map-sum-pairs/
 */

public class MapSum {

    private class Node {
        Map<Character, Node> children;
        int val;

        public Node() {
            this.children = new HashMap<>();
            this.val = 0;
        }
    }

    private final Node root;
    Set<String> set = new HashSet<>();

    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new Node();
    }

    public void insert(String key, int val) {
        Node node = root;

        for (char c : key.toCharArray()) {
            Node child = node.children.get(c);

            if (child == null) {
                child = new Node();
            }

            if (set.contains(key)) {
                child.val = val;
            } else {
                child.val += val;
            }

            node.children.put(c, child);
            node = child;
        }

        set.add(key);
    }

    public int sum(String prefix) {
        Node node = root;

        for (char c : prefix.toCharArray()) {
            Node child = node.children.get(c);

            if (child == null)
                return 0;

            node = child;
        }

        if (node != null)
            return node.val;

        return 0;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
