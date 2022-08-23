// Link: https://leetcode.com/problems/palindrome-number/

class Solution {
    public boolean isPalindrome(int x) {

        int rev = 0;
        int num = x;

        while (num > 0) {
            rev = (rev * 10) + num % 10;
            num /= 10;
        }

        return rev == x;
    }
}

// TC: O(n), SC: O(1)
