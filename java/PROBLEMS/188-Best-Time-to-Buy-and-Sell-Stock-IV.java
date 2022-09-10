// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
// Solution: https://www.youtube.com/watch?v=mFwf1YbH-Jk

class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] MinPriceArr = new int[k], profitArr = new int[k];
        Arrays.fill(MinPriceArr, Integer.MAX_VALUE);

        if (k == 0 || prices.length == 0) return 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                MinPriceArr[j] = Math.min(MinPriceArr[j], prices[i] - (j > 0 ? profitArr[j - 1] : 0));
                profitArr[j] = Math.max(profitArr[j], prices[i] - MinPriceArr[j]);
            }
        }

        return profitArr[k - 1];
    }
}

// TC: O(k) + O(n * k)
// SC: O(k) + O(k) => O(k)