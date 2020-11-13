package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date 13.11.2020.
 *
 * 116. Populating Next Right Pointers in Each Node
 *
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null)
            return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            Node next = null;

            for (int i = size-1; i >= 0; i--) {
                Node node = queue.poll();

                node.next = next;

                if (node.right != null)
                    queue.add(node.right);

                if (node.left != null)
                    queue.add(node.left);

                next = node;
            }
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
