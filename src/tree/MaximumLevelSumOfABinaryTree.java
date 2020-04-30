package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date 30.04.2020.
 *
 * 1161. Maximum Level Sum of a Binary Tree
 *
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 *
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 */

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int max = Integer.MIN_VALUE;
        int smallestLevel = 1;
        int level = 0;

        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.right != null)
                    queue.add(node.right);

                if (node.left != null)
                    queue.add(node.left);
            }

            if (sum > max) {
                max = sum;
                smallestLevel = level;
            }
        }

        return smallestLevel;
    }
}
