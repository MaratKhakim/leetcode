package linkedlist;

/**
 * Date 22.03.2020.
 *
 *  445. Add Two Numbers II
 *
 *  You are given two non-empty linked lists representing two non-negative integers.
 *  The most significant digit comes first and each of their nodes contain a single digit.
 *  Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * https://leetcode.com/problems/add-two-numbers-ii/
 */

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;

        l1 = reverse(l1);
        l2 = reverse(l2);

        int rem = 0;

        while(l1 != null && l2 != null) {
            int val = l1.val+l2.val+rem;
            res.next = new ListNode(val%10);
            rem = val/10;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int val = l1.val+rem;
            res.next = new ListNode(val%10);
            rem = val/10;
            res = res.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int val = l2.val+rem;
            res.next = new ListNode(val%10);
            rem = val/10;
            res = res.next;
            l2 = l2.next;
        }

        head = reverse(head.next);

        if (rem == 1) {
            res = new ListNode(1);
            res.next = head;
            head = res;
        }

        return head;
    }

    private ListNode reverse(ListNode list) {
        ListNode prev = null;
        ListNode curr = list;

        while(curr.next != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        curr.next = prev;

        return curr;
    }
}
