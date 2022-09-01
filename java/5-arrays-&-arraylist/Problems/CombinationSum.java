// Link: https://leetcode.com/problems/combination-sum/
// Solution: https://www.youtube.com/watch?v=obBSF4AG3qU&t=258s

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        generate(0, candidates, result, new ArrayList<>(), target);
        return result;
    }

    public void generate(int start, int[] arr, List<List<Integer>> result, List<Integer> current, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        } else if (target < 0) return;


        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            generate(i, arr, result, current, target - arr[i]);
            current.remove(current.size() - 1);
        }
    }
}


// TC: O(n * 2^n), SC: O(n)
