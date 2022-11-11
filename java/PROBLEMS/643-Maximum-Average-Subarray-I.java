// Link: https://leetcode.com/problems/maximum-average-subarray-i/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currSum = 0;

        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }

        double max = currSum;
        int l = 0, r = k;

        while (r < nums.length) {
            currSum += nums[r++] - nums[l++];
            max = Math.max(max, currSum);
        }

        return max / k;
    }
}

// TC: O(n), SC: O(1)

