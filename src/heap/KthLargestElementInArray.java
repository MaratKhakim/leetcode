package heap;

import java.util.PriorityQueue;

/**
 * Date 16.05.2020.
 *
 * 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.poll();
    }
}
