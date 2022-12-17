// Link: https://leetcode.com/problems/arranging-coins/description/


class Solution {
    public int arrangeCoins(int n) {
        int coins = 0, complete = 0;

        while (true) {
            if (++coins <= n) {
                n -= coins;
                complete++;
            }
            else break;
        }

        return complete;
    }
}

// TC: O(logn), SC: O(1)


class Solution {
    public int arrangeCoins(int n) {
        long lo = 1, hi = n;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sum = mid * (mid + 1) / 2;

            if (sum < n) lo = mid + 1;
            else if (sum > n) hi = mid - 1;
            else return (int) mid;
        }

        return (int) hi;
    }
}

// TC: O(logn), SC: O(1)