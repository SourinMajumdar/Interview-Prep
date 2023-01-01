// LLink: https://leetcode.com/problems/count-the-digits-that-divide-a-number/description/

// weekly 326, 1 jan 2023
// Q1

class Solution {
    public int countDigits(int num) {
        int x = num;
        int count = 0;

        while (num != 0) {
            int rem = num % 10;
            if (x % rem == 0) {
                count++;
            }
            num /= 10;
        }

        return count;
    }
}

// TC: O(n)
// n -> number of digits in num