// Link: https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/

// Weekly 312, 25 September 2022
// Q2

/*
We need the maximum bitwise AND.

The bitwise AND of the maximum element with itself is going to give us the maximum bitwise AND possible in the array.

So in first pass, we find the maximum element in the array and in another pass we find the length of the longest subarray containing all max elements.

Because all AND operations in [x, x, x, x] will give us x itself and that is the maximum AND possible.

Say we have a subarray [x, y, x, x] and y < x, Our AND value will decrease therefore our desired subarray becomes [x, x] which lies after the element y.
 */

class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int i : nums) {
            if (i > max) max = i;
        }

        int maxLen = 0, currLen = 0;

        for (int n : nums) {
            if (n == max) currLen++;
            else currLen = 0;
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}

// TC: O(n) + O(n) => O(n)
// SC: O(1)