// Link: https://leetcode.com/problems/third-maximum-number/

class Solution {
    public int thirdMax(int[] nums) {
        Integer max = null, max2nd = null, max3rd = null;

        for (Integer n : nums) {
            if (n.equals(max) || n.equals(max2nd) || n.equals(max3rd)) {
                continue;
            }

            if (max == null || n > max) {
                max3rd = max2nd;
                max2nd = max;
                max = n;
            }
            else if (max2nd == null || n > max2nd) {
                max3rd = max2nd;
                max2nd = n;
            }
            else if (max3rd == null || n > max3rd) {
                max3rd = n;
            }
        }

        return max3rd == null ? max : max3rd;
    }
}

// TC: O(n)