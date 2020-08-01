package string;

/**
 * Date 01.08.2020.
 *
 * 520. Detect Capital
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *  - All letters in this word are capitals, like "USA".
 *  - All letters in this word are not capitals, like "leetcode".
 *  - Only the first letter in this word is capital, like "Google".
 *
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * https://leetcode.com/problems/detect-capital/
 */

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int len = word.length();

        boolean isLastCharCapital = isCapital(word.charAt(len-1));

        for (int i = len-2; i > 0; i--) {
            if (isLastCharCapital) {
                if (!isCapital(word.charAt(i)))
                    return false;
            } else if (isCapital(word.charAt(i)))
                    return false;
        }

        return !isLastCharCapital || isCapital(word.charAt(0));
    }

    private boolean isCapital(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
