package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 20.04.2020.
 *
 * 872. Leaf-Similar Trees
 *
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 * https://leetcode.com/problems/leaf-similar-trees/
 */

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);

        return l1.equals(l2);
    }

    public void dfs(TreeNode node, List<Integer> list) {
        if (node == null)
            return;

        if (node.left == null && node.right == null)
            list.add(node.val);

        dfs(node.left, list);
        dfs(node.right, list);
    }
}
