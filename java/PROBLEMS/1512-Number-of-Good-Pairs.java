/*

LEETCODE:
Given an array of integers nums, return the number of good pairs.
A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:
Input: nums = [1,2,3,1,1,3]
Output: 4

Example 2:
Input: nums = [1,1,1,1]
Output: 6

Example 3:
Input: nums = [1,2,3]
Output: 0

Problem link: https://leetcode.com/problems/number-of-good-pairs/
 */

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;

        for (int i = 0; i < nums.length; ++i){
            for (int j = i + 1; j < nums.length; ++j){
                if (nums[i] == nums[j]) goodPairs++;
            }
        }

        return goodPairs;
    }
}