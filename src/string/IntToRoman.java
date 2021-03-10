package string;

import java.util.HashMap;
import java.util.Map;

/**
 *  12. Integer to Roman
 *
 *  Given an integer, convert it to a roman numeral.
 *  Input is guaranteed to be within the range from 1 to 3999.
 *
 *  https://leetcode.com/problems/integer-to-roman/
 */

public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = getMap();
        int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int idx = 0;

        while(num > 0) {
            int curr = arr[idx];

            if (num >= curr) {
                sb.append(map.get(curr));
                num -= curr;
            } else {
                idx++;
            }
        }

        return sb.toString();
    }

    private Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        return map;
    }
}
