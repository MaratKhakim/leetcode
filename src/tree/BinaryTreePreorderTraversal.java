package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Date 25.04.2020.
 *
 * 144. Binary Tree Preorder Traversal
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            res.add(node.val);

            if (node.right != null)
                st.push(node.right);

            if (node.left != null)
                st.push(node.left);
        }

        return res;
    }
}
