package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date 28.05.2020.
 *
 * 958. Check Completeness of a Binary Tree
 *
 * Given a binary tree, determine if it is a complete binary tree.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 */

public class CheckCompletenessOfBT {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean found = false;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    found = true;
                    continue;
                }

                if (found)
                    return false;

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
    }
}
