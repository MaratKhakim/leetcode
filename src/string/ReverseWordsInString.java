package string;

/**
 * Date 15.07.2020.
 *
 * 151. Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */

public class ReverseWordsInString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");

        for (int i = arr.length-1; i >= 0; i--) {
            String curr = arr[i];
            if (curr.isEmpty())
                continue;

            sb.append(curr);

            if (i != 0)
                sb.append(" ");
        }

        return sb.toString().trim();
    }
}
