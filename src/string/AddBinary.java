package string;

/**
 * Date 20.05.2020.
 *
 * 67. Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * https://leetcode.com/problems/add-binary/
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length()-1, j = b.length()-1;
        int mod = 0;

        StringBuilder builder = new StringBuilder();

        while(i >= 0 || j >= 0) {
            int ca = 0;
            int cb = 0;

            if (i >= 0)
                ca = a.charAt(i) - '0';

            if (j >= 0)
                cb = b.charAt(j) - '0';

            int sum = mod + ca + cb;

            mod = sum/2;
            sum = sum%2;

            builder.append(sum);
            i--;
            j--;
        }

        if (mod == 1)
            builder.append(1);

        return builder.reverse().toString();
    }
}
