package tree;

import java.util.Stack;

/**
 * Date 03.12.2020.
 *
 * 897. Increasing Order Search Tree
 *
 * Given the root of a binary search tree, rearrange the tree in in-order so that
 * the leftmost node in the tree is now the root of the tree,
 * and every node has no left child and only one right child.
 *
 * https://leetcode.com/problems/increasing-order-search-tree/
 */

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode curr = root;
        TreeNode dummy = new TreeNode(root.val);
        TreeNode res = dummy;

        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || curr != null) {
            while(curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            dummy.right = new TreeNode(curr.val);
            dummy = dummy.right;

            curr = curr.right;
        }

        return res.right;
    }
}
