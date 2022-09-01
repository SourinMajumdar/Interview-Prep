// Link: https://leetcode.com/problems/combination-sum-ii/
// Solution:

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, candidates, new ArrayList<>(), result, target);
        return result;
    }

    public void generateSubsets(int index, int[] candidates, List<Integer> current, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        } else if (target < 0) return;

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            current.add(candidates[i]);
            generateSubsets(i + 1, candidates, current, result, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}

// TC: O(n * logn) + O(n * 2^n)
// SC: O(n)