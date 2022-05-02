/*
LEETCODE:
Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).

Example 1:

Input: nums = [0,2,1,5,3,4]
Output: [0,1,2,4,5,3]

Example 2:

Input: nums = [5,0,1,2,3,4]
Output: [4,5,0,1,2,3]

Problem link: https://leetcode.com/problems/build-array-from-permutation/

 */

class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        int i=0;
        while(i<nums.length){
            ans[i]=nums[nums[i]];
            ++i;
        }
        return ans;
    }
}

