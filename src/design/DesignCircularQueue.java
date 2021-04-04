package design;

/**
 * Date 04.04.2021.
 *
 * 622. Design Circular Queue
 *
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on
 * FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 *
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full,
 * we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
 *
 * Implementation the MyCircularQueue class:
 *      - MyCircularQueue(k) Initializes the object with the capacity of the queue to be k.
 *      - int Front() Gets the front item from the queue. If the queue is empty, return -1.
 *      - int Rear() Gets the last item from the queue. If the queue is empty, return -1.
 *      - boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
 *      - boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
 *      - boolean isEmpty() Checks whether the circular queue is empty or not.
 *      - boolean isFull() Checks whether the circular queue is full or not.
 *
 *  https://leetcode.com/problems/design-circular-queue/
 */

public class DesignCircularQueue {
    private int size, capacity;
    private ListNode head, tail;

    public DesignCircularQueue(int k) {
        this.size = 0;
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        ListNode node = new ListNode(value);

        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = new ListNode(value);
            tail = tail.next;
        }

        size++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        head = head.next;
        size--;

        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;

        return head.val;
    }

    public int Rear() {
        if (isEmpty())
            return -1;

        return tail.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
