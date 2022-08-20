// Link: https://leetcode.com/problems/reverse-integer/
// Solution: https://www.youtube.com/watch?v=CRgXG1vK-wg

class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {

            if (rev < Integer.MIN_VALUE /10 || rev > Integer.MAX_VALUE /10) return 0;

            rev = (rev * 10) + (x % 10);
            x /= 10;
        }

        return rev;
    }
}

// TC: O(n), SC: O(1)