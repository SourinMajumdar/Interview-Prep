// Link: https://leetcode.com/problems/minimum-distance-to-the-target-element/description/

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(min, Math.abs(i - start));
            }
        }

        return min;
    }
}

// TC: O(n), SC: O(1)