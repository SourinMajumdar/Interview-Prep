// Link: https://leetcode.com/problems/valid-parentheses/
// Solution: https://www.youtube.com/watch?v=wkDfsKijrZ8

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            else {
                if (stack.isEmpty()) return false;

                char last = stack.pop();
                if (c == ']' && last == '[' ||
                    c == '}' && last == '{' ||
                    c == ')' && last == '(') {} // do nothing

                else return false;
            }
        }

        return stack.isEmpty();
    }
}


// TC: O(n), SC: O(n)


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }

        return stack.isEmpty();
    }
}

// TC: O(n), SC: O(n)