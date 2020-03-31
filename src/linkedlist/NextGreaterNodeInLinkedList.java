package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Date 31.03.2020.
 *
 *  1019. Next Greater Node In Linked List
 *
 *  We are given a linked list with head as the first node.
 *  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
 *
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i,
 * node_j.val > node_i.val, and j is the smallest possible choice.
 * If such a j does not exist, the next larger value is 0.
 *
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 *
 * Note that in the example inputs (not outputs) below,
 * arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2,
 * second node value of 1, and third node value of 5.
 *
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 */

public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null)
            return new int[]{0};

        int max = 0;
        List<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        ListNode node = reverse(head);

        while(node != null) {
            if (node.val >= max) {
                list.add(0);
                max = node.val;
            } else {
                while(!st.isEmpty() && st.peek() <= node.val) {
                    st.pop();
                }

                list.add(st.peek());
            }

            st.push(node.val);
            node = node.next;
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < res.length; i++)
            res[i] = list.get(res.length-i-1);

        return res;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = head.next;

        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        curr.next = prev;

        return curr;
    }
}
