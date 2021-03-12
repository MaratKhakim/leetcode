package tree;

/**
 * Date 02.01.2021.
 *
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 *
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 * The cloned tree is a copy of the original tree.
 * Return a reference to the same node in the cloned tree.
 *
 * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
 * Follow up: Solve the problem if repeated values on the tree are allowed.
 *
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 */

public class FindCorrespondingNodeOfBTInCloneOfThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null)
            return original;

        if (original == target)
            return cloned;

        TreeNode left = getTargetCopy(original.left, cloned.left, target);

        if (left != null)
            return left;

        return getTargetCopy(original.right, cloned.right, target);
    }
}