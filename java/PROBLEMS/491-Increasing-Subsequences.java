// Link: https://leetcode.com/problems/increasing-subsequences/
// Solution: https://www.youtube.com/watch?v=YsedzOvRjgw

class Solution {
    Set<List<Integer>> set = new HashSet<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        findSubsequences(nums, 0);
        return new ArrayList<>(set);
    }

    public void findSubsequences(int[] nums, int index) {
        if (path.size() > 1) set.add(new ArrayList(path));

        for (int i = index; i < nums.length; i++) {
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                findSubsequences(nums, i + 1);
                path.removeLast();  // backtrack
            }
        }
    }
}

// TC: O(n * 2^n)
// SC: O(n) -> Only hashset considered