// Link: https://leetcode.com/problems/maximum-length-of-pair-chain/description/


class Solution {
    public int findLongestChain(int[][] pairs) {
        // We sort the array on the basis of the second elements in the pairs
        // It yields us more optimal solution than if we sort it based on the first elements in the pairs
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int[] lastPair = pairs[0];  // keep a pair recorded for comparison during each iteration
        int len = 1;                // maximum length of chain by default is going to be atleast 1
        for (int i = 1; i < pairs.length; i++) {
            // if current pair's 1st element is strictly greater than previous pair's 2nd element
            if (pairs[i][0] > lastPair[1]) {
                len++;                  // length increments
                lastPair = pairs[i];    // current pair becomes last/previous pair for upcoming pairs
            }
        }

        return len;     // return the length achieved so far
    }
}

// TC: O(n * logn) + O(n) => O(n * logn)
// SC: O(1)