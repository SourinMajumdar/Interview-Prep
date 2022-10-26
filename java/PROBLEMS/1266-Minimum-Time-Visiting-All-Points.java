// Link: https://leetcode.com/problems/minimum-time-visiting-all-points/

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        for(int i = 0; i < points.length - 1; i++) {
            int xDiff = Math.abs(points[i][0] - points[i + 1][0]);
            int yDiff = Math.abs(points[i][1] - points[i + 1][1]);

            time += Math.max(xDiff, yDiff);
        }

        return time;
    }
}

// TC: O(n), SC: O(1)