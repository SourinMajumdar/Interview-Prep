// Link: https://leetcode.com/problems/increasing-triplet-subsequence/
// Solution: https://www.youtube.com/watch?v=9ACruzu6lXM


class Solution {
    public boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n > mid) return true;
            else if (n > left && n < mid) mid = n;
            else if (n < left) left = n;
        }

        return false;
    }
}

// TC: O(n), SC: O(1)


class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < l; i++)
            for (int j = i + 1;j< n; j++)
                for (int k= j + 1; k < n; k++)
                    if (nums[i] < nums[j] && nums[j] < nums[k])
                        return true;

        return false;
    }
}

// TC: O(n ^ 3), SC: O(1)