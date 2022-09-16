// Link: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/

class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int minIdx = 0, maxIdx = 0;

        // find the indices of the minimum and maximum elements in the array
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
            else if (nums[i] < nums[minIdx]) minIdx = i;
        }

        int minDel = Integer.MAX_VALUE;     // minimum deletions

        minDel = Math.min(minDel, Math.max(minIdx, maxIdx) + 1);    // if minIdx and maxIdx lie in first half of nums
        minDel = Math.min(minDel, n - Math.min(minIdx, maxIdx));    // if minIdx and maxIdx lie in second half of nums

        // if minIdx lies at first half and maxIdx at second half of nums
        if (minIdx < n / 2 && maxIdx > n / 2) {
            minDel = Math.min(minDel, minIdx + 1 + nums.length - maxIdx);
        }

        // if maxIdx lies at first half and minIdx at second half of nums
        else if (minIdx > n / 2 && maxIdx < n / 2) {
            minDel = Math.min(minDel, maxIdx + 1 + nums.length - minIdx);
        }

        return minDel;
    }
}

// TC: O(n), SC: O(1)