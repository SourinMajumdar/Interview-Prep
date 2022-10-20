// Link: https://leetcode.com/problems/gas-station/
// Solution: https://www.youtube.com/watch?v=ZUL3_p0MJio
// https://www.youtube.com/watch?v=lJwbPZGo05A&t=100s


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalCost > totalGas) return -1;

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