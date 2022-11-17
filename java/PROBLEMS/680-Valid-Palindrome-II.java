// Link: https://leetcode.com/problems/valid-palindrome-ii/

class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1, false);
    }

    public boolean isPalindrome(String s, int i, int j, boolean isDeleted) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (isDeleted) return false;

                return isPalindrome(s, i + 1, j, true) || isPalindrome(s, i, j - 1, true);
            }

            i++; j--;
        }

        return true;
    }
}


// TC: O(n), SC: O(1)