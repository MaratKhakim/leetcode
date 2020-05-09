package string;

import java.util.Stack;

/**
 * Date 09.05.2020.
 *
 * 20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * https://leetcode.com/problems/valid-parentheses/
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null)
            return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return false;

                stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{')
                    return false;

                stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[')
                    return false;

                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
