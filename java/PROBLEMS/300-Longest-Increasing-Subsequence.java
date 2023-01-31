// Link: https://leetcode.com/problems/longest-increasing-subsequence/
// Solution: https://www.youtube.com/watch?v=8kMpCOiuabc&t=148s

class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> bst = new TreeSet<>();

        for (int n : nums) {
            Integer higherOrEqual = bst.ceiling(n);     // Gets the next greater element of the current element

            if (higherOrEqual == null) bst.add(n);      // if not present, we simply add the current element
            else {
                bst.remove(higherOrEqual);              // If present, we replace it with the current element
                bst.add(n);
            }
        }

        return bst.size();
    }
}

// TC: O(n * logn) -> Addition or removal from bst takes logn time.
// SC: O(n)


class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp array will store the max length of increasing subsequences till each index
        int[] dp = new int[n];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;    // the current position is itself a subsequence of length 1
            // check from starting index to current inex, if we can make a longer subsequence
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {    // if we find an increasing subsequence
                    dp[i] = Math.max(dp[i], 1 + dp[j]); // update max length found till index i
                }
            }
        }

        int maxLen = 1;     // Array size is atleast 1
        // iterate over dp array to get the LIS length
        for (int size : dp) {
            maxLen = Math.max(size, maxLen);
        }

        return maxLen;      // return the answer
    }
}


class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }

        return maxLen;
    }
}