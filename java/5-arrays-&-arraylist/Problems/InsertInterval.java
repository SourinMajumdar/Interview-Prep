// Link: https://leetcode.com/problems/insert-interval/
// Solution: https://www.youtube.com/watch?v=NWM4e4yda0w

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        for (int[] curr_interval : intervals) {
            if (curr_interval[1] < newInterval[0]) {
                ans.add(curr_interval);
            } else if (curr_interval[0] > newInterval[1]) {
                ans.add(newInterval);
                newInterval = curr_interval;
            } else {
                newInterval[0] = Math.min(curr_interval[0], newInterval[0]);
                newInterval[1] = Math.max(curr_interval[1], newInterval[1]);
            }
        }

        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}

// TC: O(n), SC: O(n)