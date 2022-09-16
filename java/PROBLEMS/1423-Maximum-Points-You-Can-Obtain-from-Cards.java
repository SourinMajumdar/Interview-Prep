// Link: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
// Solution: https://www.youtube.com/watch?v=TsA4vbtfCvo

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = 0, r = cardPoints.length - k;

        int currSum = 0;

        for (int i = r; i < n; i++)
            currSum += cardPoints[i];

        int maxSum = currSum;

        while (r < n) {
            currSum += (cardPoints[l++] - cardPoints[r++]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}

// TC: O(k) + O(k) => O(k)
// SC: O(1)