// Link: https://leetcode.com/problems/find-pivot-index/
// Solution: https://www.youtube.com/watch?v=0PiH6Beqif8&t=19s

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int i : nums) totalSum += i;

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0) leftSum += nums[i - 1];
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
        }

        return -1;
    }
}

// TC: O(n) + O(n), SC: O(1)