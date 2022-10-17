// Link: https://leetcode.com/problems/random-pick-index/

class Solution {
    Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int randomIdx = (int) (Math.random() * list.size());
        return list.get(randomIdx);
    }
}

// TC: O(n), SC: O(n)