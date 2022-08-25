// Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

class Solution {
    public boolean check(int[] nums) {
        int pivotCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                pivotCount++;
            }
        }

        return pivotCount <= 1;
        // return pivotCount > 1 ? false : true;
    }
}

// TC: O(n), SC: O(1)