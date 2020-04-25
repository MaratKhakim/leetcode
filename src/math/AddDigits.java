package math;

/**
 * Date 25.04.2020.
 *
 * 258. Add Digits
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * https://leetcode.com/problems/add-digits/
 */

public class AddDigits {
    public int addDigits(int num) {
        if (num == 0)
            return 0;

        return num%9 == 0 ? 9 : num%9;
    }
}
