package SimplyfyPath;

import java.util.Stack;

/**
 * Created by aoshen on 4/28/16.
 *
 * Given an absolute path for a file (Unix-style), simplify it.

    For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"
 *
 */
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }

        StringBuilder sb = new StringBuilder();

        String[] splits = path.split("/");
        Stack<String> stack = new Stack<String>();

        for (int i = 0;i != splits.length;++ i) {
            if (splits[i].length() == 0 || splits[i].equals(".")) {
                continue;
            } else if (!splits[i].equals("..")) {
                stack.push(splits[i]);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        Stack<String> temp = new Stack<String>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        while (!temp.isEmpty()) {
            sb.append("/" + temp.pop());
        }

        if (sb.length() == 0) {
            sb.append("/");
        }

        return sb.toString();
    }
}
