// Link: https://leetcode.com/problems/two-city-scheduling/description/
// https://www.youtube.com/watch?v=3isvpHf5_MM

/*
We sort the array on the basis of the difference aCost - bCost.

aCost - bCost > 0 => aCost > bCost: We send candidate to city B.
aCost - bCost < 0 => aCost < bCost: We send candidate to city A.
Then add first costs.length/2 aCost to total (for sending to city A) and
the rest costs.length/2 bCost to total (for sending to city B).
That's how they'll be equally grouped.
 */

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,
                (a, b) -> (a[0] - a[1]) - (b[0] - b[1])
        );

        int total = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                total += costs[i][0];
            } else {
                total += costs[i][1];
            }
        }

        return total;
    }
}

// TC: O(n * logn), SC: O(1)