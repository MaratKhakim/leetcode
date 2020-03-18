package tree;

/**
 * Date 18.03.2020.
 *
 *  1026. Maximum Difference Between Node and Ancestor
 *
 *  Given the root of a binary tree, find the maximum value V for which there exists
 *  different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 *
 * (A node A is an ancestor of B if either:
 * any child of A is equal to B, or any child of A is an ancestor of B.)
 *
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */

public class MaxDifferenceBetweenNodeAndAncestor {
    int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        traverse(root, root.val, root.val);

        return res;
    }

    private void traverse(TreeNode node, int min, int max) {
        if (node == null)
            return;

        if (node.val > max) {
            max = node.val;
        } else if (node.val < min) {
            min = node.val;
        }

        int diffMin = Math.abs(node.val - min);
        int diffMax = Math.abs(node.val - max);

        res = Math.max(res, Math.max(diffMin, diffMax));

        traverse(node.left, min, max);
        traverse(node.right, min, max);
    }
}
