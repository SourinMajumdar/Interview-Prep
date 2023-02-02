// Link: https://leetcode.com/problems/split-two-strings-to-make-palindrome/

class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            String ap = a.substring(0, i);
            String as = a.substring(i);
            String bp = b.substring(0, i);
            String bs = b.substring(i);

            StringBuilder sb = new StringBuilder();
            sb.append(ap).append(bs);
            if (isPalindrome(sb.toString())) {
                return true;
            }

            sb.setLength(0);
            sb.append(bp).append(as);
            if (isPalindrome(sb.toString())) {
                return true;
            }
        }

        return false;
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

// TC: O(n * (4n + 2n/2)) => O(n * 5n) => O(n^2)
// SC: O(1)



class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return cut(a, b) || cut(b, a);
    }

    private boolean cut(String a, String b) {
        int i = 0, j = a.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            i++; j--;
        }

        return (i >= j)? true :
        isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}

// TC: O(n), SC: O(1)