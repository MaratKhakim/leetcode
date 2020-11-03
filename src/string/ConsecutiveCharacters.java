package string;

/**
 * Date 03.11.2020.
 *
 * 1446. Consecutive Characters
 *
 * Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
 * Return the power of the string.
 *
 * https://leetcode.com/problems/consecutive-characters/
 */

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int i = 1;
        int res = 1;
        int len = s.length();

        while(i < len) {
            int num = 1;

            while(i < len && s.charAt(i-1) == s.charAt(i)) {
                i++;
                num++;
            }

            res = Math.max(num, res);
            i++;
        }

        return res;
    }
}
