// Problem: https://leetcode.com/problems/missing-number/

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) return 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i] + 1) {
                return nums[i] + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }
}

// TC: O(n) + O(nlogn), SC: O(1)



//