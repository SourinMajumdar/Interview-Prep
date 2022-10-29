// Link: https://leetcode.com/problems/destroy-sequential-targets/

class Solution {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            int rem = i % space;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        int max = Collections.max(map.values());
        int ans = Integer.MAX_VALUE;

        for (int i : nums) {
            int rem = i % space;
            if (map.get(rem) == max) {
                ans = Math.min(ans, i);
            }
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)