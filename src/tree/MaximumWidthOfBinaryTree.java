package tree;

import java.util.LinkedList;

/**
 * Date 09.07.2020.
 *
 * 662. Maximum Width of Binary Tree
 *
 * Given a binary tree, write a function to get the maximum width of the given tree.
 * The width of a tree is the maximum width among all levels.
 * The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes
 * (the leftmost and right most non-null nodes in the level, where the null nodes
 * between the end-nodes are also counted into the length calculation.
 *
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 */

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        int width = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            Pair first = queue.peekFirst();
            Pair last = queue.peekLast();

            width = Math.max(width, last.num - first.num + 1);

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;

                if (node.left != null) {
                    queue.add(new Pair(node.left, 2 * pair.num));
                }

                if (node.right != null) {
                    queue.add(new Pair(node.right, 2 * pair.num + 1));
                }
            }
        }

        return width;
    }

    class Pair {
        TreeNode node;
        int num;

        public Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
}
