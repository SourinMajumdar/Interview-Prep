// Link: https://leetcode.com/problems/power-of-three/

class Solution {
    public boolean isPowerOfThree(int n) {
        long i = 1;

        while (i < n) {
            i *= 3;
        }

        return i == n;
    }
}

// TC: O(n / 3) -> O(n)
// SC: O(1)