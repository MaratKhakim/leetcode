package bitmanipulation;

/**
 * Date 13.06.2020.
 *
 * 405. Convert a Number to Hexadecimal
 *
 * Given an integer, write an algorithm to convert it to hexadecimal.
 * For negative integer, two’s complement method is used.
 *
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */

public class ConvertNumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0)
            return "0";
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        StringBuilder res = new StringBuilder();

        while(num != 0) {
            res.append(map[num & 15]);
            num = (num >>> 4);
        }

        return res.reverse().toString();
    }
}
