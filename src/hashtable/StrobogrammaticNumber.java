package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 13.03.2021.
 *
 * 246. Strobogrammatic Number
 *
 * Given a string num which represents an integer, return true if num is a strobogrammatic number.
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * https://leetcode.com/problems/strobogrammatic-number/
 */

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Map<Integer, Integer> pairs = getPairs();

        int i = 0, j = num.length()-1;

        while(i <= j) {
            int left = num.charAt(i)-'0';
            int right = num.charAt(j)-'0';

            if (!pairs.containsKey(right) || left != pairs.get(right))
                return false;

            i++;
            j--;
        }

        return true;
    }

    private Map<Integer, Integer> getPairs() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(6, 9);
        map.put(9, 6);
        map.put(8, 8);
        map.put(0, 0);

        return map;
    }
}
