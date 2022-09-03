// Link: https://leetcode.com/problems/strictly-palindromic-number/
// Bi Weekly 86, 3 September 2022
// Q2

class Solution {
    public boolean isStrictlyPalindromic(int n) {
        boolean[] arr = new boolean[n - 3];

        for (int i = 2; i <= n - 2; i++) {  // n
            String base = baseConverter(n, i);  // n
            arr[i - 2] = isPalindrome(base);    // n
        }

        for (boolean bool : arr) {  // n
            if (!bool) return false;
        }

        return true;
    }

    public String baseConverter(int n, int base) {  // Overall O(n)
        String ans = "";
        while (n > 0) {     // n
            int rem = n % base;
            ans += String.valueOf(rem);
            n /= base;
        }

        String rev = "";
        for (int i = ans.length() - 1; i >= 0; i--) {   // n
            rev += ans.charAt(i);
        }

        return rev;
    }

    public boolean isPalindrome(String x) {     // Overall O(n)
        String reverse = "";

        for (int i = x.length() - 1; i >= 0; i--) {     // n
            reverse += x.charAt(i);
        }

        return x.equals(reverse);   // O(n)
    }
}

// TC: O(n ^ 2) + O(n) => O(n ^ 2)
// SC: O(n)

// OR

class Solution {
    public boolean isStrictlyPalindromic(int n) {
        return false;
    }
}

// TC: O(1)