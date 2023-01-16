// Link: https://leetcode.com/problems/insert-interval/
// Solution: https://www.youtube.com/watch?v=NWM4e4yda0w

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();    // to store our final intervals
        for (int[] curr : intervals) {
            // NON-OVERLAPPING CASES:
            // if current interval's end lies strictly to left of new interval's start
            if (curr[1] < newInterval[0]) {         // example: curr = [4,6], newInterval = [7,8]
                ans.add(curr);      // add the current interval
            }
            // if new interval's end lies strictly to left of current interval's start
            else if (newInterval[1] < curr[0]) {    // example: curr = [4,6], newInterval = [2,3]
                ans.add(newInterval);   // add the new interval
                newInterval = curr;     // make the current interval as our new interval
                // because we don't need to deal with the given newInterval again
                // we still need something to compare the upcoming intervals with
            }
            // OVERLAPPING CASES:
            else {
                // if curr[0] < newInterval[1]
                // (current interval's start lies to left of new intervals' end)
                // example: curr = [3,5], newInterval = [2,4]
                // newInterval[0] becomes the min of the two interval's start (2)
                newInterval[0] = Math.min(newInterval[0], curr[0]);
                // if curr[1] > newInterval[1] or curr[1] < newInterval[1]
                // end point will be given by the max of current and new interval's end points
                // example: curr = [3,5], newInterval = [2,4], new end point: max(5, 4) = 5
                // so new interval: [2,5]
                // Or, say: curr = [3,6], newInterval = [2,4], new tnterval lies inside of current interval
                // new interval becomes: [3,6]
                newInterval[1] = Math.max(newInterval[1], curr[1]);
                // So here we just consume the non-overlapping start and ends and combine them to one single interval
            }
            // So with each iteration, intervals will be updated or added to ans list based on if they overlap or not
        }

        // The last newInterval to be added was just compared/updated but wasn't added actually
        // so now when the iteration is over, we can add it to our ans list
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);  // return the ans arraylist as a 2D array
    }
}

// TC: O(n), SC: O(n)