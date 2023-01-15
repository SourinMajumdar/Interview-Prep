// Link: https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/


// weekly 328, 15 Jan 2023
// Q1


class Solution {
    public int differenceOfSum(int[] nums) {
        int eleSum = 0;
        int digitSum = 0;
        for (int i : nums) {
            eleSum += i;
            digitSum += (i > 9)? help(i) : i;
        }

        return Math.abs(digitSum - eleSum);
    }

    private int help(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}

// TC: O(n), SC: O(1)