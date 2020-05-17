package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 17.05.2020.
 *
 * 784. Letter Case Permutation
 *
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 *
 * https://leetcode.com/problems/letter-case-permutation/
 */

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();

        if (s == null || s.isEmpty())
            return res;

        dfs(s.toCharArray(), 0, res);

        return res;
    }

    public void dfs(char[] arr, int idx, List<String> res) {
        if (idx == arr.length) {
            res.add(new String(arr));
            return;
        }

        if (Character.isDigit(arr[idx])) {
            dfs(arr, idx+1, res);
            return;
        }

        arr[idx] = Character.toUpperCase(arr[idx]);
        dfs(arr, idx+1, res);

        arr[idx] = Character.toLowerCase(arr[idx]);
        dfs(arr, idx+1, res);

    }
}
