package linkedlist;

import java.util.Stack;

/**
 * Date 10.07.2020.
 *
 * 430. Flatten a Multilevel Doubly Linked List
 *
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer, which may or may not point to a separate doubly linked list.
 * These child lists may have one or more children of their own, and so on,
 * to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * You are given the head of the first level of the list.
 *
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */

public class FlattenMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null)
            return head;

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        Node dummy = new Node();
        Node prev = dummy;

        while(!stack.isEmpty()) {
            Node curr = stack.pop();

            if (curr.next != null)
                stack.push(curr.next);

            if (curr.child != null)
                stack.push(curr.child);

            Node newNode = new Node(curr.val, null, null, null);

            prev.next = newNode;
            newNode.prev = prev;
            prev = newNode;
        }

        dummy = dummy.next;
        dummy.prev = null;

        return dummy;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };
}
