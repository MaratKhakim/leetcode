package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 29.04.2020.
 *
 * Day 28. 30-day-leetcoding-challenge.
 * First Unique Number
 *
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * Implement the FirstUnique class:
 *  -   FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 *  -   int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 *  -   void add(int value) insert value to the queue.
 */

public class FirstUniqueNumber {
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int size;

    public FirstUniqueNumber(int[] nums) {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();

        for (int num : nums)
            add(num);
    }

    public int showFirstUnique() {
        if (size == 0)
            return -1;

        return head.next.val;
    }

    public void add(int value) {
        Node node;

        if (map.containsKey(value)) {
            node = map.get(value);

            if (node != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
                map.put(value, null);
            }
        } else {
            node = new Node(value);
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;

            map.put(value, node);
            size++;
        }
    }

    private class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        FirstUniqueNumber firstUnique = new FirstUniqueNumber(new int[]{2,3,5});
        firstUnique.showFirstUnique(); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        firstUnique.showFirstUnique(); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        firstUnique.showFirstUnique(); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        firstUnique.showFirstUnique(); // return -1
    }
}
