package tree;

import java.util.Stack;

/**
 * Date 10.05.2020.
 *
 * 230. Kth Smallest Element in a BST
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;

        while(!st.isEmpty() || node != null) {
            while(node != null) {
                st.push(node);
                node = node.left;
            }

            node = st.pop();

            if (--k == 0)
                break;

            node = node.right;
        }

        return node.val;
    }
}
