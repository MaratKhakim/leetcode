package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date 22.04.2020.
 *
 * 637. Average of Levels in Binary Tree
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */

public class AverageOfLevelsInBT {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.right != null)
                    queue.add(node.right);

                if (node.left != null)
                    queue.add(node.left);
            }

            res.add(sum/size);
        }

        return res;
    }
}
