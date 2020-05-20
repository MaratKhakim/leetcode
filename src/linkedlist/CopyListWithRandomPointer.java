package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 20.05.2020.
 *
 * 138. Copy List with Random Pointer
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 *  - val: an integer representing Node.val
 *  - random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 *
 *  https://leetcode.com/problems/copy-list-with-random-pointer/
 */

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node curr = head;
        Map<Node, Node> map = new HashMap<>();
        map.put(head, new Node(head.val));

        while(curr != null) {
            Node copy = map.getOrDefault(curr, new Node(curr.val));

            if (curr.next != null) {
                copy.next = map.getOrDefault(curr.next, new Node(curr.next.val));
                map.put(curr.next, copy.next);
            }

            if (curr.random != null) {
                copy.random = map.getOrDefault(curr.random, new Node(curr.random.val));
                map.put(curr.random, copy.random);
            }

            map.put(curr, copy);
            curr = curr.next;
        }

        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
