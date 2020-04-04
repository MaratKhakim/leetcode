package dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date 04.04.2020.
 *
 * 120. Triangle
 *
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * https://leetcode.com/problems/triangle/
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        List<Integer> first = triangle.get(0);

        return first.get(0) + minimum(triangle, 1, 0, new HashMap<>());
    }

    private int minimum(List<List<Integer>> triangle, int elem, int idx, Map<String, Integer> map) {
        if (triangle.size() == elem) {
            return 0;
        }

        String key = elem + "*" + idx;

        if (map.containsKey(key))
            return map.get(key);

        List<Integer> list = triangle.get(elem);
        int curr = list.get(idx) + minimum(triangle, elem+1, idx, map);
        int next = list.get(idx+1) + minimum(triangle, elem+1, idx+1, map);

        int res = Math.min(curr, next);

        map.put(key, res);

        return res;
    }
}
