// Link: https://leetcode.com/problems/average-waiting-time/description/


class Solution {
    public double averageWaitingTime(int[][] customers) {
        double waitingTime = 0;     // to store our total waiting time
        int totalTime = 0;          // to store our time for which our chef would be busy
        for (int[] c : customers) {
            // means our chef is busy and customer has to wait
            if (c[0] < totalTime) {
                // add the order preparation time to chef's time
                // (chef won't start cooking the ordered food instantly)
                totalTime += c[1];
            } else {   // means our chef is idle
                // add the arrival time and preparation time to chef's time
                // (chef will instantly start cooking for the order)
                totalTime = c[0] + c[1];
            }
            // chef will start to cook for an order only after the previous orders are completed cooking for
            // if a customer arrives at time x and chef takes time y,
            // customer has to wait for time x-y and after that chef will take his order
            waitingTime += (totalTime - c[0]);
        }

        return waitingTime / customers.length * 1.0;    // return the average as a double
    }
}

// TC: O(n), SC: O(1)