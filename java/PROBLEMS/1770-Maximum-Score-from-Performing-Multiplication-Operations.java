// Link: https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

// Brute force (TLE)
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        return help (0, multipliers, nums, 0, nums.length - 1);
    }

    public int help (int i, int[] mul, int[] nums, int start, int end) {
        if (i == mul.length) return 0;
        int option1 = mul[i] * nums[start] + help(i + 1, mul, nums, start + 1, end);
        int option2 = mul[i] * nums[end] + help(i + 1, mul, nums, start, end - 1);
        return Math.max(option1, option2);
    }
}

// TC: O(2 ^ m), SC: O(m)


// Recurive Dp (Memoization)

class Solution {
    int[][] dp;

    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        dp = new int[m][m];

        return help(0, multipliers, nums, 0);
    }

    public int help(int i, int[] mul, int[] nums, int start) {
        if (i == mul.length) return 0;

        if (dp[i][start] != 0) return dp[i][start];

        int end = nums.length - (i - start) - 1;

        int option1 = mul[i] * nums[start] + help(i + 1, mul, nums, start + 1);
        int option2 = mul[i] * nums[end] + help(i + 1, mul, nums, start);

        return dp[i][start] = Math.max(option1, option2);
    }
}

// TC: O(m ^ 2), SC: O(m ^ 2)