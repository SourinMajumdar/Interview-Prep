// Link: https://leetcode.com/problems/permutations/
// Solution: https://www.youtube.com/watch?v=ewww8VWF-rE

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    public void backtrack(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) list.add(i);
            ans.add(list);
        }
        else {
            for (int i = index; i < nums.length; i++) {
                swap(i , index, nums);
                backtrack(nums, index + 1);
                swap(i, index, nums);
            }
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// TC: O(n! * n), SC: O(n!)