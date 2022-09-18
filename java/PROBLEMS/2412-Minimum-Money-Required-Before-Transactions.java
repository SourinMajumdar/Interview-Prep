// Link: https://leetcode.com/problems/minimum-money-required-before-transactions/
// Solution: https://www.youtube.com/watch?v=3QtpPRcinU4

class Solution {
    public long minimumMoney(int[][] transactions) {
        long spend = 0, cost = 0, cashback = 0;

        for (int[] t : transactions) {
            if (t[0] > t[1]) {
                spend += t[0] - t[1];
                cashback = Math.max(cashback, t[1]);
            }
            else cost = Math.max(cost, t[0]);
        }

        return spend + Math.max(cost, cashback);
    }
}

// TC: O(n), SC: O(1)