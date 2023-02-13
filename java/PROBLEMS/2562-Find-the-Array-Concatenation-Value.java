// Link: https://leetcode.com/problems/find-the-array-concatenation-value/description/

// weekly 332, 12 Feb 2023
// Q1

class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int i = 0, j = nums.length - 1;
        long ans = 0;
        while (i <= j) {
            // if its the absolute middle element (odd length)
            if (i == j) {
                ans += nums[i]; // just add it to ans
                break;          // we are done, break out
            }
            // get the number of digits in rightmost element
            int digits = (int) Math.floor(Math.log10(nums[j]) + 1);
            // say at right we have 13, so '2 digits'
            // so in order to accomodate 13, we will have to multiply
            // leftmost digit by 100 i.e. 10 raised to power '2'
            long x = nums[i] * (long) Math.pow(10, digits);
            ans += x + nums[j];  // add the value to ans
            i++; j--;   // move the pointers
        }

        return ans;     // return the finl answer
    }
}

// TC: O(n/2) => O(n)
// SC: O(1)