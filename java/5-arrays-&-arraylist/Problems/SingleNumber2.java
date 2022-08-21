// Link: https://leetcode.com/problems/single-number-ii/
// Solution:

class Solution {
    public int singleNumber(int[] nums) {

        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];

        for (int i = 2; i < nums.length; i += 3) {
            if(nums[i] != nums[i - 2]) {
                return nums[i - 2];
            }
        }

        return nums[nums.length - 1];
    }
}

// TC: O(nlogn) + O(n), SC: O(1)


// Using HashMap
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }
}

// TC: O(n), SC: O(n)


