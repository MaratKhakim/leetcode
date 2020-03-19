package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date 19.03.2020.
 *
 *  102. Binary Tree Level Order Traversal
 *
 *  Given a binary tree, return the level order traversal of its nodes' values.
 *  (ie, from left to right, level by level).
 *
 *  https://leetcode.com/problems/binary-tree-level-order-traversal/
 */

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                level.add(curr.val);

                if (curr.left != null)
                    queue.add(curr.left);

                if (curr.right != null)
                    queue.add(curr.right);
            }

            res.add(level);
        }

        return res;
    }
}
