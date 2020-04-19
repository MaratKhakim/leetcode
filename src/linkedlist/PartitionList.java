package linkedlist;

/**
 * Date 19.04.2020.
 *
 * 86. Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * https://leetcode.com/problems/partition-list/
 */

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode ls = new ListNode(-1);
        ListNode headLs = ls;
        ListNode gr = new ListNode(-1);
        ListNode headGr = gr;
        ListNode curr = head;

        while(curr != null) {
            if (curr.val < x) {
                ls.next = curr;
                ls = ls.next;
            } else {
                gr.next = curr;
                gr = gr.next;
            }

            curr = curr.next;
        }

        gr.next = null;
        ls.next = headGr.next;

        return headLs.next;
    }
}
