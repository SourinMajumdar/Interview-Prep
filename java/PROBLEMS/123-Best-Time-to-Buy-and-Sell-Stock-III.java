// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
// Solution: https://www.youtube.com/watch?v=YAWRyWJalM0

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice1 = Integer. MAX_VALUE, minPrice2 = Integer. MAX_VALUE;
        int profit1 = 0, profit2 = 0;

        for (int currPrice : prices) {

            minPrice1 = Math.min(currPrice, minPrice1);
            profit1 = Math.max(profit1, currPrice - minPrice1);

            minPrice2 = Math.min(minPrice2, currPrice - profit1);
            profit2 = Math.max(profit2, currPrice - minPrice2);

        }

        return profit2;
    }
}

// TC: O(n), SC: O(1)