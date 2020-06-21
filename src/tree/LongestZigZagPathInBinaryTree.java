package tree;

/**
 * Date 21.06.2020.
 *
 * 1372. Longest ZigZag Path in a Binary Tree
 *
 * Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
 *
 *  - Choose any node in the binary tree and a direction (right or left).
 *  - If the current direction is right then move to the right child of the current node otherwise move to the left child.
 *  - Change the direction from right to left or right to left.
 *  - Repeat the second and third step until you can't move in the tree.
 *  - Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 *
 * Return the longest ZigZag path contained in that tree.
 *
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 */

public class LongestZigZagPathInBinaryTree {
    int res = 0;

    public int longestZigZag(TreeNode root) {
        zigzag(root, null);

        return res;
    }

    public int zigzag(TreeNode node, Boolean isRight) {
        if (node == null)
            return 0;

        int left = zigzag(node.left, true);
        int right = zigzag(node.right, false);

        int max = Math.max(left, right);
        res = Math.max(res, max);

        if (isRight == null)
            return max+1;

        return isRight ? right+1 : left+1;
    }
}
