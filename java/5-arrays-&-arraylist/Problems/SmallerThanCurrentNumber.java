/*

LEETCODE:
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
Return the answer in an array.

Example 1:
Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]

Example 2:
Input: nums = [6,5,4,8]
Output: [2,1,0,3]

Example 3:
Input: nums = [7,7,7,7]
Output: [0,0,0,0]

Problem link: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

 */

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length;++i){
            arr[i]=0;
            for(int j=0; j<nums.length; j++){
                if(nums[i]>nums[j]) arr[i]++;
            }
        }
        return arr;
    }
}