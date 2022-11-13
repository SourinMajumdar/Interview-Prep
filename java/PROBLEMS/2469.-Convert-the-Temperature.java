// Link: https://leetcode.com/problems/convert-the-temperature/

// Weekly 319, 13 Nov, 2022
// Q1

class Solution {
    public double[] convertTemperature(double celsius) {
        double f = celsius * 1.80 + 32.00;
        double k = celsius + 273.15;
        return new double[]{k, f};
    }
}

// TC: O(1), SC: O(1)