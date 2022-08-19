// Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Solution: https://www.youtube.com/watch?v=41FBv9Jpjcs

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = Integer.MIN_VALUE;

        for (int currPrice : prices) {
            minPrice = Math.min(currPrice, minPrice);           // We need to stay at the minimum price to buy at
            int currProfit = currPrice - minPrice;              // We find out the current profit
            maxProfit = Math.max(maxProfit, currProfit);        // We compare our initial profit and current profit
        }

        return maxProfit;
    }
}

// Time complexity: O(N), Space Complexity: O(1)