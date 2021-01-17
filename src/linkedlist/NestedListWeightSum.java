package linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date 17.01.2021.
 *
 * 339. Nested List Weight Sum
 *
 * You are given a nested list of integers nestedList.
 * Each element is either an integer or a list whose elements may also be integers or other lists.
 * The depth of an integer is the number of lists that it is inside of.
 * For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
 * Return the sum of each integer in nestedList multiplied by its depth
 *
 * https://leetcode.com/problems/nested-list-weight-sum/
 */

public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        Queue<List<NestedInteger>> queue = new LinkedList<>();
        queue.add(nestedList);
        int depth = 0;
        int sum = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                List<NestedInteger> list = queue.poll();

                for (NestedInteger nested : list) {
                    if (nested.isInteger()) {
                        sum += nested.getInteger() * depth;
                    } else {
                        queue.add(nested.getList());
                    }
                }
            }
        }

        return sum;
    }

    public interface NestedInteger {
       // @return true if this NestedInteger holds a single integer, rather than a nested list.
       public boolean isInteger();

       // @return the single integer that this NestedInteger holds, if it holds a single integer
       // Return null if this NestedInteger holds a nested list
       public Integer getInteger();

       // Set this NestedInteger to hold a single integer.
       public void setInteger(int value);

       // Set this NestedInteger to hold a nested list and adds a nested integer to it.
       public void add(NestedInteger ni);

       // @return the nested list that this NestedInteger holds, if it holds a nested list
       // Return null if this NestedInteger holds a single integer
       public List<NestedInteger> getList();
  }
}
