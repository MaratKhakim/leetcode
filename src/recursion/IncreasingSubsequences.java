package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Date 02.05.2020.
 *
 * 491. Increasing Subsequences
 *
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array,
 * and the length of an increasing subsequence should be at least 2.
 *
 * https://leetcode.com/problems/increasing-subsequences/
 */

public class IncreasingSubsequences {
    List<List<Integer>> res;
    Set<List<Integer>> set;

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        set = new HashSet<>();

        if (nums == null || nums.length == 0)
            return res;

        helper(nums, new ArrayList<>(), 0);

        return res;
    }

    public void helper(int[] nums, List<Integer> list, int idx) {
        List<Integer> copy = new ArrayList<>(list);
        if (set.contains(copy))
            return;

        if (list.size() > 1) {
            res.add(copy);
            set.add(copy);
        }

        Set<Integer> set = new HashSet<>();

        for(int i = idx; i < nums.length; i++){
            int num = nums[i];

            if (i == 0 || set.add(num)) {
                if (!list.isEmpty() && list.get(list.size()-1) > num)
                    continue;

                list.add(num);
                helper(nums, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
