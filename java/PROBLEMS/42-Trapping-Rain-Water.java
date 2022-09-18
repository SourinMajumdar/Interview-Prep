// Link: https://leetcode.com/problems/trapping-rain-water/
// Solutution: https://www.youtube.com/watch?v=m18Hntz4go8


// Brute force
class Solution {
    public int trap(int[] height) {
        int units = 0;

        for (int i = 0; i < height.length; i++) {

            int leftMax = 0;
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = 0;
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            units += Math.min(leftMax, rightMax) - height[i];
        }

        return units;
    }
}

// TC: O(n ^ 2), SC: O(1)

// Better (DP)
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] leftMax = new int[n];
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, height[i]);
            leftMax[i] = maxHeight;
        }

        int[] rightMax = new int[n];
        maxHeight = 0;

        for (int i = n - 1; i >= 0; i--) {
            maxHeight = Math.max(maxHeight, height[i]);
            rightMax[i] = maxHeight;
        }

        int units = 0;

        for (int i = 0; i < n; i++) {
            units += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return units;
    }
}

// TC: O(n) + O(n) + O(n) => O(n)
// SC: O(n) + O(n) => O(n)

// Two Pointers
class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1; // left and right ptr
        int units = 0;
        int maxLeft = 0, maxRight = 0;

        while (l <= r) {
            if (height[l] <= height[r]) {
                if (height[l] > maxLeft) maxLeft = height[l];
                else units += maxLeft - height[l];
                l++;
            }
            else {
                if (height[r] > maxRight) maxRight = height[r];
                else units += maxRight - height[r];
                r--;
            }
        }

        return units;
    }
}

// TC: O(n), SC: O(1)

