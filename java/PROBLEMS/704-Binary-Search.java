// Link: https://leetcode.com/problems/binary-search/

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > target) hi = mid - 1;
            else if (nums[mid] < target) lo = mid + 1;
            else return mid;
        }

        return -1;
    }
}

// TC: O(logn)