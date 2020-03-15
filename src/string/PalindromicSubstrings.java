package string;

/**
 *  647. Palindromic Substrings
 *
 *  Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * https://leetcode.com/problems/palindromic-substrings/
 */

public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int res = 0;
        int len = 2*s.length()-1;

        for (int i = 0; i < len; i++) {
            int st, end;

            if (i%2 == 1) {
                st = i-1;
                end = i+1;
            } else {
                st = end = i;
            }

            while(st >= 0 && end < len) {
                if (s.charAt(st/2) != s.charAt(end/2)) {
                    break;
                }

                res++;
                st -= 2;
                end += 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "acacc";
        System.out.println(countSubstrings(s));
    }
}
