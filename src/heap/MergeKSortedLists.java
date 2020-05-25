package heap;

import java.util.PriorityQueue;

/**
 * Date 25.05.2020.
 *
 * 23. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null)
                minHeap.add(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        while(!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll();
            dummy.next = new ListNode(curr.val);

            if (curr.next != null)
                minHeap.add(curr.next);

            dummy = dummy.next;
        }

        return result.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
