package linkedlist;

/**
 * Date 29.03.2020.
 *
 *  876. Middle of the Linked List
 *
 *  Given a non-empty, singly linked list with head node head,
 *  return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
