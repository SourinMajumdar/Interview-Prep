// Link: https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1

class Solution {
    public boolean canPair(int[] nums, int k) {
        if (nums.length % 2 != 0) {
            return false;
        }

        int[] freq = new int[k];

        for (int n : nums) {
            int y = n % k;

            if (freq[(k - y) % k] != 0) {
                freq[(k - y) % k]--;
            }
            else freq[y]++;
        }

        for (int n : freq) {
            if (n != 0) return false;
        }

        return true;
    }
}

// TC: O(n + k), SC: O(k)