package tree;

/**
 * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 *
 * https://leetcode.com/problems/binary-tree-pruning/
 * */

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);

        if (left != null && isLeaf(left) && left.val == 0)
            root.left = null;

        if (right != null && isLeaf(right) && right.val == 0)
            root.right = null;

        return root;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
