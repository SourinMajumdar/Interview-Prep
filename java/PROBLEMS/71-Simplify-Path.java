// Link: https://leetcode.com/problems/simplify-path/
// https://www.youtube.com/watch?v=8fM6D3sMIDs


// Stack
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");

        for (String s : p) {
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            }
            else if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
                stack.push(s);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append('/').append(s);
        }

        return sb.toString();
    }
}

// TC: O(n), SC: O(n)


// Deque
class Solution {
    public String simplifyPath(String path) {
        Deque<String> dq = new LinkedList<>();
        String[] p = path.split("/");

        for (String s : p) {
            if (!dq.isEmpty() && s.equals("..")) {
                dq.poll();
            }
            else if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
                dq.push(s);
            }
        }

        if (dq.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()) {
            sb.append('/').append(dq.pollLast());
        }

        return sb.toString();
    }
}

// TC: O(n), SC: O(n)