/*
Problem link: https://leetcode.com/problems/two-sum/

Solution link:
https://www.youtube.com/watch?v=uEdnIn9_Sdo&t=842s
https://www.youtube.com/watch?v=BoHO04xVeU0&t=449s

*/

// Brute force: O(N^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; ++i){
            for(int j = i + 1; j < nums.length; ++j){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{}    // is never reached
    }
}

// Optimised: O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};    // is never reached
    }
}

// TC: O(n), SC: O(n)