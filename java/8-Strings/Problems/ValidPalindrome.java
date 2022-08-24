// Link: https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {
        String str = "";

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                str += c;
            }
        }

        str = str.toLowerCase();

        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++; j--;
        }

        return true;
    }
}

// TC: O(n) + O(n / 2), SC: O(n)


// Faster

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char l = s.charAt(i), r = s.charAt(j);

            if (!Character.isLetterOrDigit(l)) {
                i++;
            } else if (!Character.isLetterOrDigit(r)) {
                j--;
            } else if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}

// TC: O(n), SC: O(1)


