package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 07.04.2020.
 *
 * 1324. Print Words Vertically
 *
 * Given a string s. Return all the words vertically in the same order in which they appear in s.
 * Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
 * Each word would be put on only one column and that in one column there will be only one word.
 *
 * https://leetcode.com/problems/print-words-vertically/
 */

public class PrintWordsVertically {
    public List<String> printVertically(String s) {
        List<String> res = new ArrayList<>();

        int len = 0;

        String[] strs = s.split(" ");

        for (String str : strs) {
            len = Math.max(len, str.length());
        }

        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();

            for (String str : strs) {
                if (i >= str.length()) {
                    sb.append(" ");
                } else {
                    sb.append(str.charAt(i));
                }
            }

            while(sb.charAt(sb.length()-1) == ' ')
                sb.deleteCharAt(sb.length()-1);

            res.add(sb.toString());
        }

        return res;
    }
}
