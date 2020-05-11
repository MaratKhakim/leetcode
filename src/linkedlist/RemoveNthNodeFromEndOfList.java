package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 11.05.2020.
 *
 * 19. Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Given n will always be valid.
 *
 * Could you do this in one pass?
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeWithTwoPointers(head, n);
    }

    public ListNode removeWithTwoPointers(ListNode head, int n) {
        if (head == null)
            return head;

        int fast = 0;
        int slow = 0;
        ListNode fastNode = head, slowNode = head;

        while(fastNode != null) {
            ++fast;
            fastNode = fastNode.next;

            if (slow > 0) {
                slowNode = slowNode.next;
                slow++;
            } else if (fast > n) {
                slow++;
            }
        }

        if (fast == n)
            return head.next;

        slowNode.next = slowNode.next.next;

        return head;
    }

    public ListNode removeWithMap(ListNode head, int n) {
        if (head == null)
            return head;

        Map<Integer, ListNode> map = new HashMap<>();
        int idx = 0;

        ListNode curr = head;

        while(curr != null) {
            map.put(++idx, curr);
            curr = curr.next;
        }

        if (idx == n)
            return head.next;

        ListNode node = map.get(idx-n);
        node.next = node.next.next;

        return head;
    }
}
