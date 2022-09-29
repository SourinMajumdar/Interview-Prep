// Link: https://leetcode.com/problems/k-divisible-elements-subarrays/
// Solution: https://www.youtube.com/watch?v=GzWGBWDmhN0

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();

            for (int j = i; j < nums.length; j++) {
                if (nums[j] % p == 0) count++;
                if (count > k) break;

                sb.append(nums[j] + " ");
                set.add(sb.toString());
            }
        }

        return set.size();
    }
}

// TC: O(n ^ 2), SC: O(n ^ 2)