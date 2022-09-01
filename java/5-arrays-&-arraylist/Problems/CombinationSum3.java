// Link: https://leetcode.com/problems/combination-sum-iii/
// Solution: https://www.youtube.com/watch?v=b_tOVuYhEx4&t=32s

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(1, new ArrayList<>(), result, k, n);
        return result;
    }

    public void generateSubsets(int start, List<Integer> current, List<List<Integer>> result, int k, int target) {
        if (current.size() == k && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= 9; i++) {
            current.add(i);
            generateSubsets(i + 1, current, result, k, target - i);
            current.remove(current.size() - 1);
        }
    }
}

// TC: O(n * 2^n)
// SC: O(n)