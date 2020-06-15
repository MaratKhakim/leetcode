package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Date 15.06.2020.
 *
 * 824. Goat Latin
 *
 * A sentence S is given, composed of words separated by spaces.
 * Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 * https://leetcode.com/problems/goat-latin/
 */

public class GoatLatin {
    public String toGoatLatin(String s) {
        String[] strs = s.split(" ");
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o','u'));

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            if (!set.contains(Character.toLowerCase(str.charAt(0)))) {
                str = str+str.charAt(0);
                str = str.substring(1);
            }

            str = str+"ma";
            int k = i;

            while(k-- >= 0)
                str += "a";

            strs[i] = str;
        }

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            if (sb.length() > 0)
                sb.append(" ");

            sb.append(str);
        }

        return sb.toString();
    }
}
