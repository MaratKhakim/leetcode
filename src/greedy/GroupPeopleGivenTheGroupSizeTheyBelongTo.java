package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Date 20.03.2020.
 *
 *  1282. Group the People Given the Group Size They Belong To
 *
 *  There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group.
 *  Given the array groupSizes of length n telling the group size each person belongs to,
 *  return the groups there are and the people's IDs each group includes.
 *
 * You can return any solution in any order and the same applies for IDs.
 * Also, it is guaranteed that there exists at least one solution.
 *
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 */

public class GroupPeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Stack[] lists = new Stack[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i]-1;

            if (lists[idx] == null)
                lists[idx] = new Stack<Integer>();

            lists[idx].push(i);
        }

        for (int i = 0; i < lists.length; i++) {
            Stack<Integer> st = lists[i];

            if (st != null) {
                int k = 0;
                List<Integer> temp = new ArrayList<>();

                while(!st.isEmpty()) {
                    if (k++ == i+1) {
                        res.add(temp);
                        temp = new ArrayList<>();
                        k = 0;
                    } else
                        temp.add(st.pop());
                }

                res.add(temp);
            }
        }

        return res;
    }
}
