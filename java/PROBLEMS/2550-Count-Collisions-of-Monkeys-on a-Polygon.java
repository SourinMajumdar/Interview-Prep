// Link: https://leetcode.com/problems/count-collisions-of-monkeys-on-a-polygon/description/

// Weekly 330, 29 Jan 2023
// Q2

class Solution {
    public int monkeyMove(int n) {
        int mod = 1000000007;
        int ans = (int) power(2, n, mod) - 2;
        // In any case if ans is -ve, add the mod value to it
        return ans + ((ans < 0)? mod : 0);
    }

    private long power(long x, int y, int mod) {
        long res = 1;
        x %= mod;
        if (x == 0) {
            return 0;
        }
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % mod;
            }
            y >>= 1;
            x = (x * x) % mod;
        }

        return res;
    }
}

// TC: O(logn), SC: O(1)