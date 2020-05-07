package string;

import java.util.Stack;

/**
 * Date 07.05.2020.
 *
 * 71. Simplify Path
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.
 *
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names.
 * The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 *
 * https://leetcode.com/problems/simplify-path/
 */

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null)
            return path;

        int st = 0, end = 1;
        Stack<String> stack = new Stack<>();

        while(end <= path.length()) {
            if (end == path.length() || path.charAt(end) == '/') {
                if (end - st > 1) {
                    String curr = path.substring(st+1, end);

                    if (curr.equals("..")) {
                        if (!stack.isEmpty())
                            stack.pop();
                    } else if (!curr.equals(".")) {
                        stack.push(curr);
                    }
                }

                st = end;
            }

            end++;
        }

        if (stack.isEmpty())
            return "/";

        StringBuilder builder = new StringBuilder();

        while(!stack.isEmpty()) {
            builder.insert(0, stack.pop());
            builder.insert(0, "/");
        }

        return builder.toString();
    }
}
