// Link: https://leetcode.com/problems/max-points-on-a-line/description/

class Solution {
    public int maxPoints(int[][] p) {
        int n = p.length;
        if (n < 3) {
            return n;
        }

        int max = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int total = 2;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        double slope1 = (p[j][1] - p[i][1]) / ((p[j][0] - p[i][0]) * 1.0);
                        double slope2 = (p[k][1] - p[i][1]) / ((p[k][0] - p[i][0]) * 1.0);
                        if (slope1 == slope2) {
                            total++;
                        }
                    }
                }

                max = Math.max(max, total);
            }
        }

        return max;
    }
}

// TC: O(n ^ 3), SC: O(1)


class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }

        Map<Double, Integer> map;
        int max = 2;
        for (int[] x : points) {
            map = new HashMap<>();
            for (int[] y : points) {
                if (x == y) {
                    continue;
                }

                double slope = 0;
                if (y[0] == x[0]) {
                    slope = Double. POSITIVE_INFINITY;
                } else {
                    slope = (y[1] - x[1]) / ((y[0] - x[0]) * 1.0);
                }

                map.put(slope, 1 + map.getOrDefault(slope, 0));
                max = Math.max(max, 1 + map.get(slope));
            }
        }

        return max;
    }
}

// TC: O(n ^ 2)
// SC: O(n ^ 2) -> n ^ 2 unique slopes are possible