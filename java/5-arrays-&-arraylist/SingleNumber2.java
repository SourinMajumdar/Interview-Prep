// Link: https://leetcode.com/problems/single-number-ii/
// Solution:

class Solution {
    public int singleNumber(int[] nums) {

        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];

        for (int i = 2; i < nums.length - 1; i += 3) {
            if(nums[i] != nums[i - 2]) {
                return nums[i - 2];
            }
        }

        return nums[nums.length - 1];
    }
}

// TC: O(nlogn) + O(n), SC: O(1)