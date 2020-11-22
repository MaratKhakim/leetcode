package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Date 22.11.2020.
 *
 * 804. Unique Morse Code Words
 *
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
 * as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * For convenience, the full table for the 26 letters of the English alphabet is given.
 *
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
 * For example, "cab" can be written as "-.-..--...", (which is the concatenation "-.-." + ".-" + "-...").
 * We'll call such a concatenation, the transformation of a word.
 * Return the number of different transformations among all words we have.
 *
 * https://leetcode.com/problems/unique-morse-code-words/
 */

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();

        for (String word: words) {
            StringBuilder sb = new StringBuilder();

            for (char c : word.toCharArray()) {
                sb.append(morse[c-'a']);
            }

            set.add(sb.toString());
        }

        return set.size();
    }
}
