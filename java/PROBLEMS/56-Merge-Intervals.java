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


class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] curr : intervals) {
            if (curr[0] <= end) {
                end = Math.max(end, curr[1]);
            }
            else {
                ans.add(new int[] {start, end});
                start = curr[0];
                end = curr[1];
            }
        }

        ans.add(new int[] {start, end});
        return ans.toArray(new int[0][]);
    }
}