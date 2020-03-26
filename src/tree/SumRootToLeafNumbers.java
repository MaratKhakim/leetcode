package tree;

/**
 * Date 26.03.2020.
 *
 *  129. Sum Root to Leaf Numbers
 *
 *  Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int curr) {
        if (node == null)
            return 0;

        curr = 10*curr + node.val;

        if (node.left == null && node.right == null)
            return curr;

        int left = sum(node.left, curr);
        int right = sum(node.right, curr);

        return left + right;
    }
}
