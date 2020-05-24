package tree;

/**
 * Date 24.05.2020.
 *
 * 1008. Construct Binary Search Tree from Preorder Traversal
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */

public class ConstructBSTfromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length);
    }

    public TreeNode helper(int[] preorder, int st, int end) {
        if (st >= end)
            return null;

        TreeNode node = new TreeNode(preorder[st]);
        int a = end;

        for (int i = st+1; i < end; i++) {
            if (preorder[i] > preorder[st]) {
                a = i;
                break;
            }
        }

        node.left = helper(preorder, st+1, a);
        node.right = helper(preorder, a, end);

        return node;
    }
}
