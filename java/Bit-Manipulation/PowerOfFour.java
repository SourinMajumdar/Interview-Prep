// Link: https://leetcode.com/problems/power-of-four/

class Solution {
    public boolean isPowerOfFour(int n) {
        long i = 1;
        while (i < n) {
            i *= 4;
        }

        return i == n;
    }
}

// TC: O(n / 4) -> O(n)
// SC: O(1)