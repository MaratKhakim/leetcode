package tree;

/**
 * Date 13.07.2021.
 *
 * 1448. Count Good Nodes in Binary Tree
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X
 * there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    private int goodNodes(TreeNode node, int parentMaxValue) {
        if (node == null)
            return 0;

        int res = parentMaxValue > node.val ? 0 : 1;

        int max = Math.max(parentMaxValue, node.val);

        int left = goodNodes(node.left, max);
        int right = goodNodes(node.right, max);

        return res + left + right;
    }
}
