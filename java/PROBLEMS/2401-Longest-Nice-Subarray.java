// Link: https://leetcode.com/problems/longest-nice-subarray/

// Weekly 209, 4 september 2022
// Q3 

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int res = 1;
        for(int i = 0; i < nums.length - res; i++) {
            int first = nums[i];
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if ((first & nums[j]) == 0) {
                    first = first | nums[j];
                    count++;
                } else break;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}

// TC: O(n ^ 2), SC: O(1)