package linkedlist;

/**
 * Date 02.06.2020.
 *
 * 237. Delete Node in a Linked List
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
