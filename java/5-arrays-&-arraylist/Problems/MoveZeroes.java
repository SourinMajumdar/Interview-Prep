package Problems;// Link: https://leetcode.com/problems/move-zeroes/

class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int ele: nums) {
            if (ele != 0) {
                nums[k++] = ele;
            }
        }

        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}

// TC: O(n), SC: O(1)