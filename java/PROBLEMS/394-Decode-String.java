// Link: https://leetcode.com/problems/decode-string/


class Solution {
    public String decodeString(String s) {
        Stack<Integer> freqStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int n = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            }
            else if (Character.isLetter(c)) {
                sb.append(c);
            }
            else if (c == '[') {
                freqStack.push(n);
                n = 0;

                strStack.push(sb);
                sb = new StringBuilder();
            }
            else if (c == ']') {
                StringBuilder temp = sb;
                sb = strStack.pop();
                int count = freqStack.pop();

                while (count-- > 0) sb.append(temp);
            }
        }

        return sb.toString();
    }
}

// TC: O(n), SC: O(n)