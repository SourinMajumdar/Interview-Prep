// Link: https://leetcode.com/problems/longest-consecutive-sequence/


class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int count = 0, maxCount = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i + 1] == nums[i]) continue;
            else if (nums[i + 1] != nums[i] + 1) count = 0;
            else{
                count++;
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount + 1;
    }
}

// TC: O(n * logn) + O(n) => O(n *logn)
// SC: O(1)