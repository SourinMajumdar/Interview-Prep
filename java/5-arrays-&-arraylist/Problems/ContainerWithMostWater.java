// Link: https://leetcode.com/problems/container-with-most-water/
// Solution: https://www.youtube.com/watch?v=UuiTKBwPgAo

// Brute force
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int currArea = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, currArea);
            }
        }

        return maxArea;
    }
}

// TC: O(n ^ 2), SC: O(1)
// Time Limit Exceeded

// Optimal
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            int currArea = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, currArea);

            if (height[i] < height[j]) i++;
            // else if (height[i] > height[j]) j--;
            else j--;
        }

        return maxArea;
    }
}

// TC: O(n), SC: O(1)