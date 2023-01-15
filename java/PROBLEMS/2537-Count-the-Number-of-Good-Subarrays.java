// Link: https://leetcode.com/problems/count-the-number-of-good-subarrays/description/
// https://leetcode.com/problems/count-the-number-of-good-subarrays/solutions/3054978/java-sliding-window-hashmap-explained/?orderBy=most_votes

// weekly 328, 15 Jan 2023
// Q3

class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap<>();
        long ans = 0;
        int pairs = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            pairs += map.getOrDefault(nums[right], 0);
            map.put(nums[right], 1 + map.getOrDefault(nums[right], 0));
            while (pairs >= k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                pairs -= map.get(nums[left]);
                left++;
            }
            ans += left;
            right++;
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)