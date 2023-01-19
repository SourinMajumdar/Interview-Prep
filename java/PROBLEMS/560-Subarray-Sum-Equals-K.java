// Link: https://leetcode.com/problems/subarray-sum-equals-k/

// Brute force

class Solution {
    public int subarraySum(int[] nums, int k) {
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) total++;

            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) total++;
            }
        }

        return total;
    }
}

// TC: O(n ^ 2), SC: O(1)


// Optimal
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int total = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum - k;
            total += map.getOrDefault(rem, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return total;
    }
}

// TC: O(n), SC: O(n)


