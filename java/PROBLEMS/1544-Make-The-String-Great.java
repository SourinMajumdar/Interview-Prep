// Link: https://leetcode.com/problems/make-the-string-great/

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char top = '0';
            if (!stack.isEmpty()) top = stack.peek();
            char curr = s.charAt(i);

            if (toLower(top) == toLower(curr) &&
                ((isUpper(top) && isLower(curr)) ||
                (isLower(top) && isUpper(curr)))) {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public char toLower(char c)    {return Character.toLowerCase(c);}
    public boolean isLower(char c) {return Character.isLowerCase(c);}
    public boolean isUpper(char c) {return Character.isUpperCase(c);}
}

// TC: O(n), SC: O(n)


class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) == 32) {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}

// TC: O(n), SC: O(n)