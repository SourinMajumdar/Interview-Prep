// Link: https://leetcode.com/problems/edit-distance/description/

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        return dp[m][n];
    }
}

// TC: O(m+n) + O(m*n)
// SC: O(m*n)

class Solution {
    public int minDistance(String word1, String word2) {
        return help(word1, word2);
    }

    private int help(String s, String t) {
        if (s.length() == 0) {
            return t.length();
        }
        if (t.length() == 0) {
            return s.length();
        }
        if (s.charAt(0) == t.charAt(0)) {
            return help(s.substring(1), t.substring(1));
        }

        int ins = help(s.substring(0), t.substring(1));
        int del = help(s.substring(1), t.substring(0));
        int rep = help(s.substring(1), t.substring(1));
        return 1 + Math.min(ins, Math.min(del, rep));
    }
}