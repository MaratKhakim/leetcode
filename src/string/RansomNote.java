package string;

/**
 * Date 03.05.2020.
 *
 * 383. Ransom Note
 *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise,
 * it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * https://leetcode.com/problems/ransom-note/
 */

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];

        for (char c : magazine.toCharArray())
            letters[c-'a']++;

        for (char c : ransomNote.toCharArray()) {
            letters[c-'a']--;

            if (letters[c-'a'] < 0)
                return false;
        }

        return true;
    }
}
