package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 28.10.2020.
 *
 * 228. Summary Ranges
 *
 * You are given a sorted unique integer array nums.
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *   - "a->b" if a != b
 *   - "a" if a == b
 *
 * https://leetcode.com/problems/summary-ranges/
 */

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> res = new ArrayList<>();

        if (len == 0)
            return res;

        int st = nums[0], end = nums[0];
        int idx = 0;

        while(idx < len) {
            st = end = nums[idx];

            while(idx+1 < len && nums[idx]+1 == nums[idx+1]) {
                end = nums[idx+1];
                idx++;
            }

            if (st == end) {
                res.add(String.valueOf(st));

            } else {
                res.add(st+"->"+end);
            }
            idx++;
        }

        return res;
    }
}
