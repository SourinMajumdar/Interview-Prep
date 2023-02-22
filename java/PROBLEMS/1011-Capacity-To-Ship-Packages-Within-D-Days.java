// Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0, hi = 0;
        for (int w : weights) {
            lo = Math.max(lo, w);
            hi += w;
        }

        int res = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;   // assuming mid as our capacity
            if (canBeShipped(weights, mid) <= days) {
                hi = mid - 1;
                res = mid;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }

    private int canBeShipped(int[] weights, int capacity) {
        int ships = 1, currCapacity = 0;
        for (int w : weights) {
            currCapacity += w;
            if (currCapacity > capacity) {
                ships++;
                currCapacity = w;
            }
        }

        return ships;
    }
}

// TC: O(n + n * logm)  => O(n * logm)
// SC: O(1)