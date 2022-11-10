// Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        return sb.toString();

        // return stack.stream().map(a -> a.toString()).collect(Collectors.joining(""));
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = sb.length();

            if (sb.length() == 0) {
                sb.append(c);
                continue;
            }

            if (sb.charAt(len - 1) == c) {
                sb.setLength(len - 1);
            }

            else sb.append(c);
        }

        return sb.toString();
    }
}

// TC: O(n), SC: O(1)