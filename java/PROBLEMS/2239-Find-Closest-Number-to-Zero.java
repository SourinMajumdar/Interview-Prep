// Link: https://leetcode.com/problems/find-closest-number-to-zero/

class Solution {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;

        for (int n : nums) {
            if (Math.abs(n) < min) {
                min = Math.abs(n);
                ans = n;
            }
            else if (Math.abs(n) == min) {
                ans = Math.max(ans, n);
            }
        }

        return ans;
    }
}

// TC: O(n), SC: O(1)