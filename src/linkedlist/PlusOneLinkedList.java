package linkedlist;

/**
 * Date 16.12.2020.
 *
 * 369. Plus One Linked List
 *
 * Given a non-negative integer represented as a linked list of digits, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * https://leetcode.com/problems/plus-one-linked-list/
 */

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode reversed = reverse(head);

        int rem = 10;
        ListNode curr = reversed, temp = reversed;

        while(curr != null && rem != 0) {
            int val = curr.val+1;
            curr.val = val % 10;
            rem = val/10;
            curr = curr.next;
        }

        ListNode res = reverse(temp);

        if (rem == 0)
            return res;

        ListNode node = new ListNode(1);
        node.next = res;

        return node;
    }

    private ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
