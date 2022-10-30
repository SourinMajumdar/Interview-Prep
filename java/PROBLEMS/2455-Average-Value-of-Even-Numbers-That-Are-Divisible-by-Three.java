// Link: https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/

// weekly 317, 30 oct 2022
// Q1

class Solution {
    public int averageValue(int[] nums) {
        int n = 0;
        int sum = 0;
        for (int i : nums) {
            if (i % 3 == 0 && i % 2 == 0) {
                sum += i;
                n++;
            }
        }

        return n == 0 ? 0 : sum / n;
    }
}

// TC: O(n)