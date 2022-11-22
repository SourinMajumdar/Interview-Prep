// Link: https://leetcode.com/problems/perfect-squares/
// https://www.youtube.com/watch?v=aZuQXkO0-XA

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                int remaining = i - j * j;
                min = Math.min(dp[remaining], min);
            }

            dp[i] = min + 1;
        }

        return dp[n];
    }
}

// TC: O(n * sqrt(n)), SC: O(n)
