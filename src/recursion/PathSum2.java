package recursion;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 28.03.2020.
 *
 *  113. Path Sum II
 *
 *  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * https://leetcode.com/problems/path-sum-ii/
 */

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        pathSum(root, sum, new ArrayList<>(), res);

        return res;
    }

    private void pathSum(TreeNode node, int sum, List<Integer> list, List<List<Integer>> res) {
        if (node == null)
            return;

        sum -= node.val;

        if (sum == 0 && node.left == null && node.right == null) {
            list.add(node.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        list.add(node.val);
        pathSum(node.left, sum, list, res);
        pathSum(node.right, sum, list, res);
        list.remove(list.size()-1);
    }
}
