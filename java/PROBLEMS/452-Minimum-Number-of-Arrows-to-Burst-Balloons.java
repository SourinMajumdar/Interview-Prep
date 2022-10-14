// Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
// Solution: https://www.youtube.com/watch?v=zBCglI35CSQ

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int reach = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > reach) {
                arrows++;
                reach = points[i][1];
            }
        }

        return arrows;
    }
}

// TC: O(n *  logn) + O(n) => O(n * logn)
// SC: O(1)