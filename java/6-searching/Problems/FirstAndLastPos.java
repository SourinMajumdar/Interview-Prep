/*
LEETCODE:
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Problem link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

 */


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        ans[0] = search(nums, target, true);    // will look for the element in the left sub-array to get the first pos
        if(ans[0]!=-1) ans[1] = search(nums, target, false);    // will look for the element in the right sub-array to get the last pos
        return ans;
    }

    int search(int[] nums, int target, boolean findStartIndex){
        int ans = -1;
        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<nums[mid]) end = mid-1;
            else if (target>nums[mid]) start = mid+1;
            else{
                ans = mid; // potential ans found, but still would look for first and last index further in both sides
                if(findStartIndex) end = mid-1;
                else start = mid+1;
            }
        }
        return ans;
    }
}