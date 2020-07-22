package array;

import java.util.Stack;

/**
 * Date 22.07.2020.
 *
 * 946. Validate Stack Sequences
 *
 * Given two sequences pushed and popped with distinct values,
 * return true if and only if this could have been the result of a sequence of push and
 * pop operations on an initially empty stack.
 *
 * https://leetcode.com/problems/validate-stack-sequences/
 */

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len1 = pushed.length, len2 = popped.length;

        Stack<Integer> st = new Stack<>();
        int j = 0;

        for (int i = 0; i < len1; i++) {
            st.push(pushed[i]);

            while(!st.isEmpty() && j < len2 && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }

        return st.isEmpty();
    }
}
