// Link: https://leetcode.com/problems/number-of-arithmetic-triplets/

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {

        Set<Integer> set = new HashSet<>();

        for (int x : nums) set.add(x);

        int ans = 0;

        for (int x : nums) {
            if (set.contains(x - diff) && set.contains(x + diff)) ans++;
        }

//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (set.contains(nums[i] - diff) && set.contains(nums[i] - 2 * diff)) ans++;
//        }

        return ans;
    }
}

// TC: O(n), SC: O(n)