package design;

/**
 * Date 10.04.2020.
 *
 * 155. Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *  - push(x) -- Push element x onto stack.
 *  - pop() -- Removes the element on top of the stack.
 *  - top() -- Get the top element.
 *  - getMin() -- Retrieve the minimum element in the stack.
 *
 *  https://leetcode.com/problems/min-stack/
 */

public class MinStack {

    private class Node {
        Node prev;
        Node next;
        int val;
        int min;

        public Node(Node prev, Node next, int val, int min) {
            this.prev = prev;
            this.next = next;
            this.val = val;
            this.min = min;
        }
    }

    private Node head;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(null, null, x, x);
            min = x;
        } else {
            if (x < min) {
                min = x;
            }

            head.next = new Node(head, null, x, min);
            head = head.next;
        }
    }

    public void pop() {
        head = head.prev;
        if (head != null)
            min = head.min;
    }

    public int top() {
        if (head == null)
            return 0;

        return head.val;
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
