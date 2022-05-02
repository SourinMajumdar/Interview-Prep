/*

LEETCODE:
Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

Example 1:
Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]

Input: nums = [1,3,2,1]
Output: [1,3,2,1,1,3,2,1]

Problem link: https://leetcode.com/problems/concatenation-of-array/
*/

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        int i = 0;
        while(i<n){
            ans[i]=nums[i];
            ans[i+n]=nums[i];
            ++i;
        }
        return ans;
    }
}