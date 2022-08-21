// Problem: https://leetcode.com/problems/single-number/
// Solution:

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];
        for (int i = 1; i < nums.length; i += 2) {
            if(nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }

        return nums[nums.length - 1];
    }
}

// TC: O(nlogn) + O(n), SC: O(1)



// Using XOR
// 0^a = a
// a^b
// a^b^a = (a^a)^b = 0^b
// In this way only the number which is unique (lets say b) remains till the end
class Solution {
    public int singleNumber(int[] nums) {

        int ans = 0;

        for (int num : nums) ans ^= num;

        return ans;
    }
}

// TC: O(n), SC: O(1)