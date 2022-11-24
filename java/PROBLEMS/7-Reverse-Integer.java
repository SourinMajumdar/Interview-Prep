// Link: https://leetcode.com/problems/reverse-integer/

class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }

            rev = (rev * 10) + (x % 10);
            x /= 10;
        }

        return rev;
    }
}

// TC: O(n), SC: O(1)

class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        x = Math.abs(x);

        long rev = 0;

        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }

        if (rev > Integer.MAX_VALUE) return 0;
        return isNeg ? (int) -rev : (int) rev;
    }
}

// TC: O(n), SC: O(1)