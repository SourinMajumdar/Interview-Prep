// Link: https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
// Solution: https://www.youtube.com/watch?v=BjiYPy7lknM

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) return -1;

        int dp[][] = new int[d + 1][jobDifficulty.length];
        for (int[] a : dp) Arrays.fill(a, -1);

        return dfs(jobDifficulty, dp, d, 0);
    }

    public int dfs(int[] jobDifficulty, int[][] dp, int d, int idx) {
        if (d == 1) {
            int max = 0;

            while (idx < jobDifficulty.length) {
                max = Math.max(max, jobDifficulty[idx++]);
            }

            return max;
        }

        if (dp[d][idx] != -1) return dp[d][idx];

        int leftMax = 0, res = Integer.MAX_VALUE;

        for (int i = idx; i < jobDifficulty.length - d + 1; i++) {
            leftMax = Math.max(leftMax, jobDifficulty[i]);
            int rightMax = dfs(jobDifficulty, dp, d - 1, i + 1);
            res = Math.min(res, leftMax + rightMax);
        }

        return dp[d][idx] = res;
    }
}

// TC: O(d * n) + , SC: O(d * n),