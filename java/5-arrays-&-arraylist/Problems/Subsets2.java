// Link: https://leetcode.com/problems/subsets-ii/
// Solution:

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int n = result.size();
            for (int i = 0; i < n; i++) {
                List<Integer> current = new ArrayList<>(result.get(i));
                current.add(num);
                Collections.sort(current);
                if (!result.contains(current)) result.add(current);
            }
        }

        return result;
    }
}

// TC: O(n * 2^n * n * logn) -> O(n^2 * 2^n * logn)
// SC: O(n * 2^n)