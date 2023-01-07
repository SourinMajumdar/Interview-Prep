// Link: https://leetcode.com/problems/gas-station/
// Solution: https://www.youtube.com/watch?v=ZUL3_p0MJio
// https://www.youtube.com/watch?v=lJwbPZGo05A&t=100s




// check if total gas is < than total cost, if yes  its impossible so return -1
// else, start moving from the beginning, if remaining gas < 0 means we can't move further
// in such case, we put start as i + 1 as it can be our potential position to return
// otherwise our gas stays collected in remainingGas and we keep moving further
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalCost > totalGas) {
            return -1;
        }

        int remainingGas = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            remainingGas += (gas[i] - cost[i]);
            if (remainingGas < 0) {
                remainingGas = 0;
                start = i + 1;
            }
        }

        return start;
    }
}

// TC: O(n), SC: O(1)


// start moving from the beginning, if remaining gas < 0 means we can't move further
// in such case, we put start as i + 1 as it can be our potential position to return
// otherwise our gas stays collected in remainingGas and we keep moving further
// mean while keep calculating extra gas for the whole journey, if its < 0 means we cant complete our journey so return -1
// else return start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remainingGas = 0, extra = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            extra += (gas[i] - cost[i]);
            remainingGas += (gas[i] - cost[i]);
            if (remainingGas < 0) {
                remainingGas = 0;
                start = i + 1;
            }
        }

        return extra < 0? -1 : start;
    }
}

// TC: O(n), SC: O(1)