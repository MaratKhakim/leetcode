package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 25.03.2020.
 *
 *  17. Letter Combinations of a Phone Number
 *
 *  Given a string containing digits from 2-9 inclusive,
 *  return all possible letter combinations that the number could represent.
 *
 *  https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return res;

        String[] nums = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        combinations(digits.toCharArray(), 0, nums, new StringBuilder(), res);

        return res;
    }

    private void combinations(char[] digits, int idx, String[] nums, StringBuilder sb, List<String> res) {
        if (idx > digits.length)
            return;

        if (idx == digits.length) {
            res.add(new String(sb));
            return;
        }

        int num = Integer.valueOf(digits[idx]-'0');
        String str = nums[num-2];

        for (char c : str.toCharArray()) {
            sb.append(c);
            combinations(digits, idx+1, nums, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
