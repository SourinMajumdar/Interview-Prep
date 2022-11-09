// Link: https://leetcode.com/problems/smallest-index-with-equal-value/

class Solution {
    public int smallestEqual(int[] nums) {
        int min = 101;

        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                min = Math.min(min, i);
            }
        }

        return min == 101 ? -1 : min;
    }
}

// TC: O(n), SC: O(1)