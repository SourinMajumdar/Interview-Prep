// Link: https://leetcode.com/problems/largest-triangle-area/
// https://leetcode.com/problems/largest-triangle-area/discuss/2700009/JAVA-or-Brute-force-or-using-function-or-Mathematical-formula

class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0.0;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++) {
                    double currArea = area(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, currArea);
                }

        return maxArea;
    }

    public double area(int[] p1, int[] p2, int[] p3) {
        return
            Math.abs(
                p1[0] * (p2[1] - p3[1]) +
                p2[0] * (p3[1] - p1[1]) +
                p3[0] * (p1[1] - p2[1])
            ) / 2.0 ;
    }
}

// TC: O(n ^ 3), SC: O(1)