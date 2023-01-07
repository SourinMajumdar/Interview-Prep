// Link: https://leetcode.com/problems/categorize-box-according-to-criteria/

// biweekly 95, 7 Jan 2023
// Q1


class Solution {
    public String categorizeBox(int l, int w, int h, int m) {
        long v = (long) l * w * h;
        int f = 10000, n = 1000000000;
        boolean bulky = v >= n || l >= f || w >= f || h >= f;
        boolean heavy = m >= 100;

        if (bulky && heavy) {
            return "Both";
        } else if (bulky && !heavy) {
            return "Bulky";
        } else if (!bulky && heavy) {
            return "Heavy";
        }
        return "Neither";
    }
}

// TC: O(1), SC: O(1)