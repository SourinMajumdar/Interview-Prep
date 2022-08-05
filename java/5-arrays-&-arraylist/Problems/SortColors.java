// Problem: https://leetcode.com/problems/sort-colors/
// Solution: https://www.youtube.com/watch?v=uvB-Ns_TVis

class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 1) return;

        int  start = 0, end = nums.length - 1, i = 0;

        while( start < end && i <= end ) {
            if (nums[i] == 0) {
                nums[i] = nums[start];
                nums[start] = 0;
                i++; start++;
            } else if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                i++;
            }
        }
    }
}

// TC: O(n) + O(n * logn) --> O(n * logn),  SC: O(1)