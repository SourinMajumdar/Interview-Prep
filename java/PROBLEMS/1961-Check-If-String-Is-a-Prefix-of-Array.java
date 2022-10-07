// Link: https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/

class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length && sb.length() < s.length(); i++) {
            sb.append(words[i]);
        }

        return s.equals(sb.toString());
    }
}

// TC: O(n)