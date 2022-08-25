// Link: https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = nums[0];

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.get(max) < entry.getValue()) {
                max = entry.getKey();
            }
        }

        return max;
    }
}


// TC: O(n), SC: O(n)
