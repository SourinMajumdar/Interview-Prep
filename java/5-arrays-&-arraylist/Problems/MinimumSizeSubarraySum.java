// Link: https://leetcode.com/problems/minimum-size-subarray-sum/
// Solution: https://www.youtube.com/watch?v=jKF9AcyBZ6E

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

// TC: O(n), SC: O(1)