package recursion;

import java.util.*;

/**
 * Date 12.04.2020.
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * https://leetcode.com/problems/subsets-ii/
 */

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<>(), new HashSet<>(), res);

        return res;
    }

    private void subsets(int[] nums, int idx, List<Integer> list, Set<List> set, List<List<Integer>> res) {
        List<Integer> copy = new ArrayList<>(list);

        if (set.add(copy)) {
            res.add(copy);
        }

        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(nums, i+1, list, set, res);
            list.remove(list.size()-1);
        }
    }
}
