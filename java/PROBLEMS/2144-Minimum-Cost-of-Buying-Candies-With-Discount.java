// Link: https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/description/

class Solution {
    public int minimumCost(int[] cost) {
        // Sort the array
        // we will obtain costlier prices at the and and cheaper ones at the beginning
        Arrays.sort(cost);
        int totalCost = 0;  // store our total cost incurred
        // start iterating from the back
        for (int i = cost.length - 1; i >= 0 ; i -= 3) {
            // say we have prices 3,4,5. We first added 5 (max) to total,
            // then 4 (second max) to total and we skip 3.
            // because 3 <= min(4,5)
            totalCost += cost[i];   // adding the max to total

            // say we are left with only 1 single price,
            // so index i-1 will lie out of bounds
            // so to check that, if we are in bounds we add the second max
            if (i - 1 >= 0) {
                totalCost += cost[i - 1];   // adding the second max to total
            }
        }

        return totalCost;
    }
}

// TC: O(n * logn) + O(n / 3) => O(n * logn)
// SC: O(1)