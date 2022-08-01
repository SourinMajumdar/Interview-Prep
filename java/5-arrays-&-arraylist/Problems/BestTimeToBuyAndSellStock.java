// Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Solution: https://www.youtube.com/watch?v=41FBv9Jpjcs

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for (int currPrice : prices) {
            min = Math.min(currPrice, min);      // We need to stay at the minimum price to buy at
            maxProfit = Math.max(maxProfit, currPrice - min);       // Then we compare the initial and current max profit
        }

        return maxProfit;
    }
}

// Time complexity: O(N), Space Complexity: O(1)