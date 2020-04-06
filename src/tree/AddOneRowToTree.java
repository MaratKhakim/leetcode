package tree;

/**
 * Date 06.04.2020.
 *
 * 623. Add One Row to Tree
 *
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
 *
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1,
 * create two tree nodes with value v as N's left subtree root and right subtree root.
 * And N's original left subtree should be the left subtree of the new left subtree root,
 * its original right subtree should be the right subtree of the new right subtree root.
 * If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree,
 * and the original tree is the new root's left subtree.
 *
 * https://leetcode.com/problems/add-one-row-to-tree/
 */

public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        return addOneRow(root, v, d, 1);
    }

    public TreeNode addOneRow(TreeNode node, int v, int d, int depth) {
        if (node == null || d < depth)
            return node;

        if (d == depth+1) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            TreeNode curr = new TreeNode(v);
            curr.left = left;
            node.left = curr;

            TreeNode currRight = new TreeNode(v);
            currRight.right = right;
            node.right = currRight;

            return node;
        }

        node.left = addOneRow(node.left, v, d, depth+1);
        node.right = addOneRow(node.right, v, d, depth+1);

        return node;
    }
}
