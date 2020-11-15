package tree;

/**
 * Date 15.11.2020.
 *
 * 938. Range Sum of BST
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 *
 * https://leetcode.com/problems/range-sum-of-bst/
 */

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        int left = root.val < low ? 0 : rangeSumBST(root.left, low, high);
        int right = root.val > high ? 0 : rangeSumBST(root.right, low, high);

        int res = left + right;

        if (root.val >= low && root.val <= high)
            res += root.val;

        return res;
    }
}
