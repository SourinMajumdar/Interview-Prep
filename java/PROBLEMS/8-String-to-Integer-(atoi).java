// Link: https://leetcode.com/problems/string-to-integer-atoi/

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;

        boolean isNeg = false;

        int i = 0;
        if(s.charAt(0) == '-' || s.charAt(0) == '+') {
            isNeg = s.charAt(0) == '-';
            i++;
        }

        int n = 0;

        for(int j = i; j < s.length(); j++) {
            int c = s.charAt(j) - '0';
            if(c < 0 || c > 9) break;

            if(n > (Integer.MAX_VALUE - c) / 10 ) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            n = n * 10 + c;
        }

        return isNeg ? - n : n;
    }
}

// TC: O(n), SC: O(1)