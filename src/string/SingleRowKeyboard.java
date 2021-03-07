package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 07.03.2021.
 *
 * 1165. Single-Row Keyboard
 *
 * There is a special keyboard with all keys in a single row.
 * Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25),
 * initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character.
 * The time taken to move your finger from index i to index j is |i - j|.
 * You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.
 *
 * https://leetcode.com/problems/single-row-keyboard/
 */

public class SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keyboard.length(); i++)
            map.put(keyboard.charAt(i), i);

        int res = 0;
        int prev = 0;

        for (int i = 0; i < word.length(); i++) {
            int index = map.get(word.charAt(i));
            res += Math.abs(prev - index);
            prev = index;
        }

        return res;
    }
}
