package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date 14.05.2020.
 *
 * 515. Find Largest Value in Each Tree Row
 *
 * You need to find the largest value in each row of a binary tree.
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        if (root == null)
            return values;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

            values.add(max);
        }

        return values;
    }
}
