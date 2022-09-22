// Link: https://leetcode.com/problems/reverse-string-ii/
// Solution: https://www.youtube.com/watch?v=WTSxcEXZi48

class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, s.length() - 1);

            while (start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }

        return new String(chars);
    }
}

// TC: O(n), SC: O(n)