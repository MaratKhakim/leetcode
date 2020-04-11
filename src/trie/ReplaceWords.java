package trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date 11.04.2020.
 *
 * 648. Replace Words
 *
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor.
 * For example, the root an, followed by other, which can form another word another.
 *
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it.
 * If a successor has many roots can form it, replace it with the root with the shortest length.
 *
 * You need to output the sentence after the replacement.
 *
 * https://leetcode.com/problems/replace-words/
 */

public class ReplaceWords {
    private class Trie {
        private class Node {
            Map<Character, Node> children;
            boolean isWord;
            String word;

            public Node() {
                children = new HashMap<>();
                isWord = false;
            }
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;

            for (char c : word.toCharArray()) {
                Node child = node.children.get(c);

                if (child == null) {
                    child = new Node();
                    node.children.put(c, child);
                }

                node = child;
            }

            node.isWord = true;
            node.word = word;
        }

        public String findSuccessor(String word) {
            Node node = root;

            for (char c : word.toCharArray()) {
                node = node.children.get(c);

                if (node == null)
                    return word;

                if (node.isWord)
                    return node.word;
            }

            return word;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();

        for (String str : dict)
            trie.insert(str);

        String[] words = sentence.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String str : words) {
            String newStr = trie.findSuccessor(str);
            sb.append(newStr).append(" ");
        }

        return sb.toString().trim();
    }
}
