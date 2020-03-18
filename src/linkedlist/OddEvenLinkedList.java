package linkedlist;

/**
 * Date 18.03.2020.
 *
 *  328. Odd Even Linked List
 *
 *  Given a singly linked list, group all odd nodes together followed by the even nodes.
 *  Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * https://leetcode.com/problems/odd-even-linked-list/
 */

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode next = head.next;
        ListNode even = next;

        while(next !=null && next.next != null) {
            curr.next = next.next;
            curr = curr.next;

            next.next = curr.next;
            next = next.next;
        }

        curr.next = even;

        return head;
    }
}
