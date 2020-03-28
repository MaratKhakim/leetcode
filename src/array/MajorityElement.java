package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 28.03.2020.
 *
 *  169. Majority Element
 *
 *  Given an array of size n, find the majority element.
 *  The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * https://leetcode.com/problems/majority-element/
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int halfLen = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);

            if (map.get(num) > halfLen)
                return num;
        }

        return -1;
    }
}
