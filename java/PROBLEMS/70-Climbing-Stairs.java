// Link: https://leetcode.com/problems/climbing-stairs/


class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int climbStairs(int n) {
        if(n < 3) return n;
        int a = 1, b = 2;

        for (int i = 2; i < n; i++) {
            int temp = b;
            b += a;
            a = temp;
        }

        return b;
    }
}

// TC: O(n), SC: O(1)