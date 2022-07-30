/*
Problem link: https://leetcode.com/problems/plus-one/
Solution: https://www.youtube.com/watch?v=_sls9AdBymI
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i>=0; --i){
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // if false
        }

        // When all elements are 9
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}

// TC: O(N), SC: O(N)