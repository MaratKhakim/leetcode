package tree;

/**
 * Date 21.03.2020.
 *
 *  108. Convert Sorted Array to Binary Search Tree
 *
 *  Given an array where elements are sorted in ascending order,
 *  convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int low, int hi) {
        if (low > hi)
            return null;

        int mid = low + (hi-low)/2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid-1);
        node.right = helper(nums, mid+1, hi);

        return node;
    }
}
