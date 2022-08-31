class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> unique = new HashSet<>();
        backtrack(nums, unique, 0);

        return new ArrayList(unique);
    }

    // Finding all permutations (from problem Permutation 1)

    void backtrack(int[] nums, Set<List<Integer>> unique, int index) {

        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) list.add(i);
            unique.add(list);

        } else {
            for (int i = index; i < nums.length; i++) {
                swap(i , index, nums);
                backtrack(nums, unique, index + 1);
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

// TC: O(n! * n), SC: O(m)
// m -> number of unique permutations