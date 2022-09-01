// Link: https://leetcode.com/problems/combinations/
// Solution: https://www.youtube.com/watch?v=fqrOsZdKegQ

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(1, n, new ArrayList<>(), result, k);
        return result;
    }

    public void generateSubsets(int start, int n, List<Integer> current, List<List<Integer>> result, int k) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            generateSubsets(i + 1, n, current, result, k);
            current.remove(current.size() - 1);
        }
    }
}

// TC: O(n * 2^n)
// SC: O(n)