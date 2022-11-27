// Link: https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
// https://www.youtube.com/watch?v=TMN268YMWzg


class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, ans = 0;
        Map<Integer, Integer>[] map = new Map[n];

        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                long Diff = (long) nums[j] - (long) nums[i];
                if (Diff <= Integer.MIN_VALUE || Diff > Integer.MAX_VALUE)  continue;

                int diff = (int) Diff;
                int n1 = map[i].getOrDefault(diff, 0);  // APs ending at i
                int n2 = map[j].getOrDefault(diff, 0);  // APs ending at j
                ans += n2;

                map[i].put(diff, n1 + n2 + 1);
            }
        }

        return ans;
    }
}

// TC: O(n ^ 2), SC: O(n ^ 2)