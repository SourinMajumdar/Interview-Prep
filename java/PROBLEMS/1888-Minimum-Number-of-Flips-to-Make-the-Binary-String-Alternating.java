// Link: https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
// https://www.youtube.com/watch?v=MOeuK6gaC2A


class Solution {
    public int minFlips(String s) {
        StringBuilder sb = new StringBuilder(s).append(s);

        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            if (i % 2 == 0) {
                alt1.append(0);
                alt2.append(1);
            }
            else {
                alt1.append(1);
                alt2.append(0);
            }
        }

        int diff1 = 0, diff2 = 0;
        int l = 0;

        int res = sb.length();

        for (int r = 0; r < sb.length(); r++) {
            if (alt1.charAt(r) != sb.charAt(r)) diff1++;
            if (alt2.charAt(r) != sb.charAt(r)) diff2++;

            if (r - l + 1 > s.length()) {
                if (alt1.charAt(l) != sb.charAt(l)) diff1--;
                if (alt2.charAt(l) != sb.charAt(l)) diff2--;
                l++;
            }

            if (r - l + 1 == s.length()) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }

        return res;
    }
}

// TC: O(n), SC: O(1)