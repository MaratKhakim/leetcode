package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Date 16.04.2020.
 *
 * 449. Serialize and Deserialize BST
 *
 * Design an algorithm to serialize and deserialize a binary search tree.
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */

public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "*";

        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(serialize(root.left)).append(",");
        sb.append(serialize(root.right));

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));

        return deserialize(queue.poll(), queue);
    }

    private TreeNode deserialize(String curr, Queue<String> queue) {
        if (queue.isEmpty() || curr.equals("*"))
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(curr));

        node.left = deserialize(queue.poll(), queue);
        node.right = deserialize(queue.poll(), queue);

        return node;
    }
}
