// Link: https://leetcode.com/problems/maximum-ice-cream-bars/description/


class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // We'll sort the array so that we get the least costs at the beginning
        // This will maximise our quantity of purchase
        // We initialise a variable to count the number of ice creams bought
        Arrays.sort(costs);
        int count = 0;
        for (int c : costs) {
            // if coins available >= cost of icecream, buy it
            if (coins >= c) {
                coins -= c;     // decrement the coins by the current cost
                count++;        // increment the count by 1
            }
            // else we have found a cost greater than our coins available
            // so makes no sense to iterate further, so break out of the loop
            else break;
        }

        return count;       // return the number of ice creams bought
    }
}

// TC: O(n * logn) + O(n) => O(n * logn)
// SC: O(1)