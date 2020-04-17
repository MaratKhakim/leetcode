package string;

import java.util.Stack;

/**
 * Date 17.04.2020.
 *
 * 1209. Remove All Adjacent Duplicates in String II
 *
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters
 * from s and removing them causing the left and the right side of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 *
 * It is guaranteed that the answer is unique.
 *
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */

public class RemoveAllAdjacentDuplicatesInString2 {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(new Pair(c, 1));
            } else {
                Pair prev = st.peek();

                if (prev.key != c) {
                    st.push(new Pair(c, 1));
                    continue;
                }

                if (prev.val != k-1) {
                    st.push(new Pair(c, prev.val+1));
                    continue;
                }

                int copy = k-1;
                while(!st.isEmpty() && copy-- > 0)
                    st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {
            sb.insert(0, st.pop().key);
        }

        return sb.toString();
    }

    private class Pair {
        char key;
        int val;

        public Pair(char key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
