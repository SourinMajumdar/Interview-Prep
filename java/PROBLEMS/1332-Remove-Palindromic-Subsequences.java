// Link: https://leetcode.com/problems/remove-palindromic-subsequences/description/


class Solution {
    public int removePalindromeSub(String s) {
        return isPalindrome(s)? 1 : 2;
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}


class Solution {
    public int removePalindromeSub(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return 2;
            }

            i++; j--;
        }

        return 1;
    }
}

// TC: O(n). SC: O(1)