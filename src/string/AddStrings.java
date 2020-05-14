package string;

/**
 * Date 14.05.2020.
 *
 * 415. Add Strings
 *
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * https://leetcode.com/problems/add-strings/
 */

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int i = num1.length()-1, j = num2.length()-1;
        int carry = 0;

        while(i >= 0 || j >= 0) {
            int digit1 = 0, digit2 = 0;

            if (i >= 0)
                digit1 = num1.charAt(i)-'0';

            if (j >= 0)
                digit2 = num2.charAt(j)-'0';

            int sum = digit1+digit2+carry;
            carry = sum/10;

            builder.append(sum%10);

            i--;
            j--;
        }

        if (carry == 1)
            builder.append(carry);

        return builder.reverse().toString();
    }
}
