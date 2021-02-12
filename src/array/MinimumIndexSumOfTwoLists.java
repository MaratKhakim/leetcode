package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date 12.02.2021.
 *
 * 599. Minimum Index Sum of Two Lists
 *
 * Suppose Andy and Doris want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 *
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> mapStringToIndex1 = getMapStringToIndex(list1);
        Map<String, Integer> mapStringToIndex2 = getMapStringToIndex(list2);

        Map<Integer, List<String>> common = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (String key1 : mapStringToIndex1.keySet()) {
            if (mapStringToIndex2.containsKey(key1)) {
                int idx = mapStringToIndex1.get(key1)+mapStringToIndex2.get(key1);
                common.putIfAbsent(idx, new ArrayList<>());
                common.get(idx).add(key1);
                min = Math.min(min, idx);
            }
        }

        List<String> list = common.get(min);
        String[] result = new String[list.size()];

        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        return result;
    }

    private Map<String, Integer> getMapStringToIndex(String[] list) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list.length; i++) {
            map.put(list[i], i);
        }

        return map;
    }
}
