// Link: https://leetcode.com/problems/factorial-trailing-zeroes/description/

class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i *= 5) {
            ans += n / i;
        }

        return ans;
    }
}

// TC: O(log5(n)), SC: O(1)