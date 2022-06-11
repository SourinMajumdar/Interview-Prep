// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        if(nums[start]<nums[end]) return nums[0];   // case where array is not rotated at all
        if(nums[start]==nums[end]) return nums[start];  // case where there is only 1 element in the array

        //finding the pivot and returning the next element (because the element next to the pivot will be the minimum)
        while(start<=end){
            int mid = start + (end-start)/2;

            if(mid<end && nums[mid]>nums[mid+1]) return nums[mid+1];
            if(mid>start && nums[mid]<nums[mid-1]) return nums[mid];
            if(nums[start]>nums[mid]) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
}