package tree;

import java.util.*;

/**
 * Date 05.04.2020.
 *
 * 863. All Nodes Distance K in Binary Tree
 *
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.
 * The answer can be returned in any order.
 *
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        map.put(root, null);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                    map.put(node.left, node);
                }

                if (node.right != null) {
                    queue.add(node.right);
                    map.put(node.right, node);
                }
            }
        }

        queue.add(target);

        Set<TreeNode> set = new HashSet<>();

        while(!queue.isEmpty() && k-- > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                set.add(node);

                if (node.left != null && !set.contains(node.left)) {
                    queue.add(node.left);
                }

                if (node.right != null && !set.contains(node.right)) {
                    queue.add(node.right);
                }

                TreeNode parent = map.get(node);

                if (parent != null && !set.contains(parent)) {
                    queue.add(parent);
                }
            }
        }

        while(!queue.isEmpty())
            res.add(queue.poll().val);

        return res;
    }
}
