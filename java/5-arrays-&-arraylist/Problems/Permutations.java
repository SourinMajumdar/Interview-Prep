// Link: https://leetcode.com/problems/permutations/
// Solution: https://www.youtube.com/watch?v=ewww8VWF-rE

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, 0);
        return ans;
    }

    void backtrack(int[] nums, List<List<Integer>> ans, int index) {

        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) list.add(i);
            ans.add(list);

        } else {
            for (int i = index; i < nums.length; i++) {
                swap(i , index, nums);
                backtrack(nums, ans, index + 1);
                swap(i, index, nums);
            }
        }
    }

    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// TC: O(n! * n), SC: O(n!)