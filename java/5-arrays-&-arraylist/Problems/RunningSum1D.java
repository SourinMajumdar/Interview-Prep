/*

LLETCODE:
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.

Example 1:
Input: nums = [1,2,3,4]
Output: [1,3,6,10]

Example 2:
Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]

Example 3:
Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]

Problem link: https://leetcode.com/problems/running-sum-of-1d-array/

 */


class Solution {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i<nums.length; ++i){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}

// TC: O(n), SC: O(1)