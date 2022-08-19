// Link: https://leetcode.com/problems/two-furthest-houses-with-different-colors/

class Solution {
    public int maxDistance(int[] colors) {
        int max = Integer.MIN_VALUE;;
        int n = colors.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (colors[j] != colors[i]) {
                    int diff = Math.abs(j - i);
                    max = Math.max(max, diff);
                }
            }
        }

        return max;
    }
}

// TC: O(n^2), SC: O(1)