// Link: https://leetcode.com/problems/longest-square-streak-in-an-array/description/

// weekly 323, 11 dec 2022
// Q2


class Solution {
    public int longestSquareStreak(int[] nums) {
        int maxLen = 0;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int len = 1;

            while (set.contains(n * n)) {
                n *= n;
                len++;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen > 1? maxLen : -1;
    }
}

// TC: O(n) + O(n) => O(n)
// SC: O(n)