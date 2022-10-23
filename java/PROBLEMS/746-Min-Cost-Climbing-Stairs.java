// Link: https://leetcode.com/problems/min-cost-climbing-stairs/
// Solution: https://www.youtube.com/watch?v=Umqh2XOGtD8


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        for(int i = 2; i < n; i++){
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[n - 1], cost[n - 2]);
    }
}

// TC: O(n), SC: O(1)
