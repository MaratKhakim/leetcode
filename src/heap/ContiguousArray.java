package heap;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 26.05.2020.
 *
 * 525. Contiguous Array
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * https://leetcode.com/problems/contiguous-array/
 */

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;

            if (map.containsKey(sum)) {
                res = Math.max(i-map.get(sum), res);
            } else {
                map.put(sum, i);
            }
        }

        return res;
    }
}
