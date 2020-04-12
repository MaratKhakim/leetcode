package tree;

import java.util.*;

/**
 * Date 12.04.2020.
 *
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */

public class BTZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.right != null)
                    queue.add(node.right);

                if (node.left != null)
                    queue.add(node.left);
            }

            if (level%2 == 1)
                Collections.reverse(list);

            res.add(list);
            level++;
        }

        return res;
    }
}
