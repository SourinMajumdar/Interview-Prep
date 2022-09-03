// Link: https://leetcode.com/problems/strictly-palindromic-number/
// Bi Weekly 86, 3 September 2022
// Q2

class Solution {
    public boolean isStrictlyPalindromic(int n) {
        boolean[] arr = new boolean[n - 3];

        for (int i = 2; i < n - 1; i++) {
            String base = baseConverter(n, i);
            arr[i - 2] = isPalindrome(base);
        }

        for (boolean bool : arr) {
            if (!bool) return false;
        }

        return true;
    }

    public String baseConverter(int n, int base) {
        String ans = "";
        while (n > 0) {
            int rem = n % base;
            ans += String.valueOf(rem);
            n /= base;
        }

        String rev = "";
        for (int i = ans.length() - 1; i >= 0; i--) {
            rev += ans.charAt(i);
        }

        return rev;
    }

    public boolean isPalindrome(String s) { // n / 2 => n
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }

        return true;
    }
}

// TC: O(n ^ 2) + O(n) => O(n ^ 2)
// SC: O(n)

class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i < n - 1; i++) {
            String s = Integer.toString(n, i);  // returns i-th base of argument n
            if (!isPalindrome(s)) return false;
        }

        return true;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }

        return true;
    }
}

// TC: O(n ^ 2), O(1)

// OR

class Solution {
    public boolean isStrictlyPalindromic(int n) {
        return false;
    }
}

// TC: O(1)