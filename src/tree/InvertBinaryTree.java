package tree;

/**
 * Date 01.06.2020.
 *
 * 226. Invert Binary Tree
 *
 * Invert a binary tree.
 *
 * https://leetcode.com/problems/invert-binary-tree/
 */

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;

        return root;
    }
}
