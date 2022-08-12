// Link: https://leetcode.com/problems/merge-intervals/
// Solution: https://www.youtube.com/watch?v=qKczfGUrFY4


class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        int[] curr_interval = intervals[0];
        ans.add(curr_interval);

        for (int[] interval : intervals) {
            int curr_begin = curr_interval[0];
            int curr_end = curr_interval[1];

            int next_begin = interval[0];
            int next_end = interval[1];

            if (curr_end >= next_begin) {
                curr_interval[1] = Math.max(curr_end, next_end);

            } else {
                curr_interval = interval;
                ans.add(curr_interval);
            }
        }

        return ans.toArray(new int[ans.size()][]);

    }
}

// TC: O(nlogn) + O(n), SC: O(n)