package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 06.07.2020.
 *
 * 66. Plus One
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * https://leetcode.com/problems/plus-one/
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();

        int rem = 0;
        int sum = rem + digits[digits.length-1] + 1;
        rem = sum / 10;
        list.add(sum % 10);

        for (int i = digits.length-2; i >= 0; i--) {
            sum = rem + digits[i];
            rem = sum / 10;
            list.add(sum % 10);
        }

        if (rem == 1)
            list.add(1);

        int [] res = new int[list.size()];
        int idx = 0;

        for (int i = list.size()-1; i >= 0; i--)
            res[idx++] = list.get(i);

        return res;
    }
}
