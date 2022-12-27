// Link: https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/


class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        // get the vacancy
        for (int i = 0; i < rocks.length; i++) {
            capacity[i] -= rocks[i];
        }

        // sort the capacity array, we want to fill as many bags as possible
        // we can achieve it only if we get the bags with lesser vacanies first
        Arrays.sort(capacity);

        int fullBags = 0;
        for (int i = 0; i < rocks.length; i++) {
            // fill the bags
            // if bag is not full, fill it and increase count.
            // if already full, can't fill it but the count still increases
            if (additionalRocks >= capacity[i]) {
                additionalRocks -= capacity[i];
                fullBags++;
            }
        }

        return fullBags;
    }
}


// TC: O(n), SC: O(1)