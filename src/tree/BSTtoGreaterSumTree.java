package tree;

import java.util.Stack;

/**
 * Date 24.03.2020.
 *
 *  1038. Binary Search Tree to Greater Sum Tree
 *
 *  Given the root of a binary search tree with distinct values,
 *  modify it so that every node has a new value equal to
 *  the sum of the values of the original tree that are greater than or equal to node.val.
 *
 *  https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */

public class BSTtoGreaterSumTree {
    public TreeNode bstToGst(TreeNode root) {
        int a = 0;

        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || curr != null) {
            if (curr == null) {
                TreeNode node = st.pop();
                node.val = node.val + a;
                a = node.val;
                curr = node.left;
            } else {
                st.push(curr);
                curr = curr.right;
            }
        }

        return root;
    }
}
