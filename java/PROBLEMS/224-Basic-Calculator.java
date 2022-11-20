// Link: https://leetcode.com/problems/basic-calculator/
// https://www.youtube.com/watch?v=BjDczS5uQ-g


class Solution {
    public int calculate(String s) {
        int n = s.length();
        int sign = 1, sum = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int currNo = c - '0';

                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    currNo = currNo * 10 + s.charAt(i + 1) - '0';
                    i++;
                }

                currNo *= sign;
                sum += currNo;
                sign = 1;
            }
            else if (c == '+') sign = 1;
            else if (c == '-') sign = -1;
            else if (c == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }
            else if (c == ')') {
                sum *= stack.pop();     // stack.pop() = previous sign
                sum += stack.pop();     // stack.pop() = previous sum so far
            }
        }

        return sum;
    }
}

// TC: O(n), SC: O(n)