package linkedlist;

/**
 * Date 01.04.2021.
 *
 * 234. Palindrome Linked List
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 *
 * https://leetcode.com/problems/palindrome-linked-list/
 */

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return false;

        if (head.next == null)
            return true;

        ListNode midNode = getMidNode(head);

        ListNode reversed = reverse(midNode.next);
        midNode.next = null;

        return isEqual(head, reversed);
    }

    private ListNode getMidNode(ListNode node) {
        ListNode slow = node, fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private boolean isEqual(ListNode node1, ListNode node2) {
        while(node1 != null && node2 != null) {
            if (node1.val != node2.val)
                return false;

            node1 = node1.next;
            node2 = node2.next;
        }

        return true;
    }
}
