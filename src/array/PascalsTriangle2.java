package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 12.06.2020.
 *
 * 119. Pascal's Triangle II
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * https://leetcode.com/problems/pascals-triangle-ii/
 */

public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i-1; j > 0; j--) {
                list.set(j, list.get(j-1)+list.get(j));
            }

            list.add(1);
        }

        return list;
    }
}
