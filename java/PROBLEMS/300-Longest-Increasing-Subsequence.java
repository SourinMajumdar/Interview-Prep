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