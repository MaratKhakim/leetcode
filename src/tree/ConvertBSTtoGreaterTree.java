package tree;

import java.util.Stack;

/**
 * Date 13.05.2020.
 *
 * 538. Convert BST to Greater Tree
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree
 * such that every key of the original BST is changed to the original key
 * plus sum of all keys greater than the original key in BST.
 *
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */

public class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        int sum = 0;
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;

        while(!st.isEmpty() || node != null) {
            while (node != null) {
                st.push(node);
                node = node.right;
            }

            node = st.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }

        return root;
    }
}
