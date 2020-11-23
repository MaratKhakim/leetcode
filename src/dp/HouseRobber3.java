package dp;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 23.11.2020.
 *
 * 337. House Robber III
 *
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * https://leetcode.com/problems/house-robber-iii/
 */

public class HouseRobber3 {
    public int rob(TreeNode root) {
        return rob(root, true, new HashMap<>());
    }

    private int rob(TreeNode node, boolean canRob, Map<TreeNode, Integer> map) {
        if (node == null)
            return 0;

        if (!canRob) {
            return rob(node.left, true, map) + rob(node.right, true, map);
        }

        if (map.containsKey(node))
            return map.get(node);

        int notRobbed = rob(node.left, true, map) + rob(node.right, true, map);
        int robbed = node.val + rob(node.left, false, map) + rob(node.right, false, map);

        int res = Math.max(robbed, notRobbed);
        map.put(node, res);

        return res;
    }
}
