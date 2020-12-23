package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date 23.12.2020.
 *
 * 1602. Find Nearest Right Node in Binary Tree
 *
 * Given the root of a binary tree and a node u in the tree,
 * return the nearest node on the same level that is to the right of u, or return null if u is the rightmost node in its level.
 *
 * https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
 */

public class FindNearestRightNodeInBinaryTree {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean found = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (found)
                    return node;

                if (node.val == u.val)
                    found = true;

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return null;
    }
}
