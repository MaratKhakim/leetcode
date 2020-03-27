package recursion;

import java.util.*;

/**
 * Date 27.03.2020.
 *
 *  47. Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * https://leetcode.com/problems/permutations-ii/
 */

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        boolean[] flags = new boolean[nums.length];
        Arrays.sort(nums);
        permute(nums, 0, flags, new HashSet<>(), new ArrayList<>(), res);

        return res;
    }

    private void permute(int[] nums, int idx, boolean[] flags, Set<List> set, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            List<Integer> arr = new ArrayList<>(list);

            if (set.contains(arr))
                return;

            res.add(arr);
            set.add(arr);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flags[i])
                continue;
            flags[i] = true;
            list.add(nums[i]);
            permute(nums, i, flags, set, list, res);
            list.remove(list.size()-1);
            flags[i] = false;
        }
    }
}
