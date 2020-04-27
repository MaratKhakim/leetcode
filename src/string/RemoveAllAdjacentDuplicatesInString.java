package string;

import java.util.Stack;

/**
 * Date 27.04.2020.
 *
 * 1047. Remove All Adjacent Duplicates In String
 *
 * Given a string S of lowercase letters, a duplicate removal consists of choosing
 * two adjacent and equal letters,and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 * It is guaranteed the answer is unique.
 *
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty())
            sb.append(stack.pop());

        return sb.reverse().toString();
    }
}
