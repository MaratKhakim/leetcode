package string;

import java.util.Stack;

/**
 * Date 09.05.2020.
 *
 * 1249. Minimum Remove to Make Valid Parentheses
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that
 * the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *  -   It is the empty string, contains only lowercase characters, or
 *  -   It can be written as AB (A concatenated with B), where A and B are valid strings, or
 *  -   It can be written as (A), where A is a valid string.
 *
 *  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (open > 0) {
                    open--;
                    stack.push(c);
                }

                continue;
            }

            if (c == '(')
                open++;

            stack.push(c);
        }

        StringBuilder builder = new StringBuilder();

        while(!stack.isEmpty()) {
            char curr = stack.pop();

            if (curr == '(' && open-- > 0) {
                continue;
            }

            builder.append(curr);
        }

        return builder.reverse().toString();
    }
}
