// Link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if (isEvenDigits(n)) count++;
        }

        return count;
    }

    public boolean isEvenDigits(int num) {
        int len = Integer.toString(num).length();
        // int len = (int) (Math.log10(element)) + 1;
        return len == 0 ? false : len % 2 == 0;
    }
}

// TC: O(n)