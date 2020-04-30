package string;

/**
 * Date 30.04.2020.
 *
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes.
 * The string is separated into N+1 groups by N dashes.
 *
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters,
 * except for the first group which could be shorter than K, but still must contain at least one character.
 * Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 *
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 *
 * https://leetcode.com/problems/license-key-formatting/
 */

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        int len = s.length();

        StringBuilder res = new StringBuilder();
        int i = len-1;

        while(i >= 0) {
            StringBuilder sb = new StringBuilder();

            while(i >= 0 && sb.length() != k) {
                if (s.charAt(i) != '-') {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                }

                i--;
            }

            while(i >= 0 && s.charAt(i) == '-')
                i--;

            res.append(sb);

            if (i >= 0)
                res.append('-');
        }

        return res.reverse().toString();
    }
}
