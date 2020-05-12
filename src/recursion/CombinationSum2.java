package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date 12.05.2020.
 *
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *  - All numbers (including target) will be positive integers.
 *  - The solution set must not contain duplicate combinations.
 *
 *  https://leetcode.com/problems/combination-sum-ii/
 */

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        sum(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    public void sum(int[] candidates, int idx, int target, List<Integer> list, List<List<Integer>> result) {
        if (target < 0)
            return;

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i == idx || candidates[i] != candidates[i-1]) {
                list.add(candidates[i]);
                sum(candidates, i+1, target-candidates[i], list, result);
                list.remove(list.size()-1);
            }
        }
    }
}
