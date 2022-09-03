// Link: https://leetcode.com/problems/find-subarrays-with-equal-sum/
// Bi Weekly 86, 3 September 2022
// Q1

class Solution {
    public boolean findSubarrays(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            int sum1 = nums[i] + nums[i + 1];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int sum2 = nums[j] + nums[j + 1];
                if (sum1 == sum2) return true;
            }
        }

        return false;
    }
}

// TC: O(n ^ 2), SC: O(1)


class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (set.contains(sum)) return true;
            set.add(sum);
        }

        return false;
    }
}

// TC: O(n), SC: O(n)