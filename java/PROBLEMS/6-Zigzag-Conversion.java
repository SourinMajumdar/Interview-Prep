// Link: https://leetcode.com/problems/zigzag-conversion/description/
// https://www.youtube.com/watch?v=Q2Tw6gcVEwc

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            int increment = 2 * (numRows - 1);
            for (int i = r; i < s.length(); i += increment) {
                sb.append(s.charAt(i));
                if (r > 0 && r < numRows - 1 &&
                        i + increment - 2 * r < s.length()) {
                    sb.append(s.charAt(i + increment - 2 * r));
                }
            }
        }

        return sb.toString();
    }
}

// TC: O(n), SC: O(1)