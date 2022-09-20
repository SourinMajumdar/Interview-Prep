// Link: https://leetcode.com/problems/maximum-length-of-repeated-subarray/
// Solution: https://www.youtube.com/watch?v=hmXH7MzcGv4

/*
nums1 = [1,2,4,5], nums2 = [5,7,2,4]

             1     2     4     5       <- nums1
    |-----------------------------|
    |  0  |  0  |  0  |  0  |  0  |    -> nums1.length + 1
    |-----------------------------|
  5 |  0  |  0  |  0  |  0  |  1  |
    |-----------------------------|
  7 |  0  |  0  |  0  |  0  |  0  |       2D dp array
    |-----------------------------|
  2 |  0  |  0  |  1  |  0  |  0  |
    |-----------------------------|
  4 |  0  |  0  |  0  |  2  |  0  |
    |-----------------------------|
       ^
  ^   nums2.length + 1
nums2

max = 2 <- answer

*/


class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        int max = 0;
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}

// TC: O(n * m), SC: O(n * m)

