// Link: https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/


class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

// TC: O(n ^ 2) SC: O(1)



class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n : nums) {
            if (map.containsKey(n + k)) {
                count += map.getOrDefault(n + k, 0);
            }
            if (map.containsKey(n - k)) {
                count += map.getOrDefault(n - k, 0);
            }
            map.put(n, 1 + map.getOrDefault(n, 0));
        }

        return count;
    }
}

// TC: O(n), SC: O(n)