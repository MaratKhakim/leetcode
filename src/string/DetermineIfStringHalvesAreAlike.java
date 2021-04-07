package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Date 07.04.2021.
 *
 * 1704. Determine if String Halves Are Alike
 *
 * You are given a string s of even length. Split this string into two halves of equal lengths,
 * and let a be the first half and b be the second half.
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
 * Notice that s contains uppercase and lowercase letters.
 *
 * Return true if a and b are alike. Otherwise, return false.
 *
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 */

public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = getVowels();

        int i = 0, j = s.length()-1;
        int left = 0, right = 0;

        while(i <= j) {
            if (set.contains(s.charAt(i++)))
                left++;

            if (set.contains(s.charAt(j--)))
                right++;
        }

        return left == right;
    }

    private Set<Character> getVowels() {
        return new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    }
}
