package linkedlist;

/**
 * Date 17.03.2020.
 *
 *  24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;

        ListNode curr = head;
        ListNode prev = new ListNode(-1);
        ListNode next = head.next;
        ListNode res = head.next;

        while(curr != null && next != null) {
            ListNode temp = next.next;
            next.next = curr;
            curr.next = temp;
            prev.next = next;
            prev = curr;

            curr = curr.next;

            if (curr != null)
                next = curr.next;
        }

        return res == null ? head : res;
    }
}
