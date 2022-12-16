// Link: https://leetcode.com/problems/monotonic-array/description/


class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return true;
        }

        boolean isIncreasing = nums[n - 1] > nums[0];

        for (int i = 1; i < n; i++) {
            if (isIncreasing) {
                if (nums[i - 1] > nums[i]) {
                    return false;
                }
            }
            else {
                if (nums[i - 1] < nums[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}

// TC: O(n), SC: O(1)