// Link: https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/

// Weekly 315, 16 Oct 2022
// Q1

class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) set.add(i);

        int ans = -1;

        for (int i : nums) {
            if (i > 0 && set.contains(-i)) {
                ans = Math.max(ans, i);
            }
        }

        return ans;
    }
}

// TC: O(n), SC: O(1)