package linkedlist;

/**
 * Date 01.11.2020.
 *
 * 1290. Convert Binary Number in a Linked List to Integer
 *
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * Return the decimal value of the number in the linked list.
 *
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */

public class ConvertBinaryNumberLinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        ListNode curr = head;

        while(curr != null) {
            res = curr.val + 2 * res;
            curr = curr.next;
        }

        return res;
    }
}
