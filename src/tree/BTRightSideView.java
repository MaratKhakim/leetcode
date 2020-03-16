package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  199. Binary Tree Right Side View
 *
 *  Given a binary tree, imagine yourself standing on the right side of it,
 *  return the values of the nodes you can see ordered from top to bottom.
 *
 *  https://leetcode.com/problems/binary-tree-right-side-view
 */

public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();

                if (i == size-1) {
                    res.add(node.val);
                }

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return res;
    }
}
