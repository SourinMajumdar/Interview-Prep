// Link: https://leetcode.com/problems/remove-k-digits/

class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";

        Stack<Character> stack = new Stack<>();

        int i = 0;

        while (i < num.length()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
            i++;
        }

        while (k-- > 0) stack.pop();

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}

// TC: OO(n), SC: O(n)