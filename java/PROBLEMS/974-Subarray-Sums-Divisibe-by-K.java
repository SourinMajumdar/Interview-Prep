// Link: https://leetcode.com/problems/subarray-sums-divisible-by-k/
// Solution: https://www.youtube.com/watch?v=QM0klnvTQzk

// Brute force
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) total++;
            }
        }

        return total;
    }
}

// O(n ^ 2), SC: O(1)

// Optimal
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int total = 0, sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;

            if (rem < 0) rem += k;

            if (map.containsKey(rem)) {
                total += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }

            map.putIfAbsent(rem, 1);
        }

        return total;
    }
}

// TC: O(n), SC: O(n)

