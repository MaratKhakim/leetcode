package linkedlist;

import tree.TreeNode;

/**
 * Date 02.07.2020.
 *
 * 109. Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in
 * which the depth of the two subtrees of every node never differ by more than 1.
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */

public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    public TreeNode helper(ListNode head, ListNode tail) {
        if (head == null || head == tail)
            return null;

        ListNode list = getMidNode(head, tail);

        TreeNode node = new TreeNode(list.val);
        node.left = helper(head, list);
        node.right = helper(list.next, tail);

        return node;
    }

    public ListNode getMidNode(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;

        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
