// Link: https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(c);
            }
        }

        String str = sb.toString().toLowerCase();

        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}

// TC: O(n) + O(n / 2) => O(n)
// SC: O(1)


class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char l = s.charAt(i), r = s.charAt(j);

            if (!Character.isLetterOrDigit(l)) {
                i++;
            }
            else if (!Character.isLetterOrDigit(r)) {
                j--;
            }
            else if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }
            else {
                i++; j--;
            }
        }

        return true;
    }
}

// TC: O(n), SC: O(1)


class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}

// TC: O(n), SC: O(1)

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        StringBuilder sb = new StringBuilder();
        sb.append(s);

        return sb.toString().equals(sb.reverse().toString());
    }
}

// TC: O(n), SC: O(1)