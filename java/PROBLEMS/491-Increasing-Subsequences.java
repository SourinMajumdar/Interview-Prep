// Link: https://leetcode.com/problems/increasing-subsequences/
// Solution: https://www.youtube.com/watch?v=YsedzOvRjgw

class Solution {
    private Set<List<Integer>> set;
    public List<List<Integer>> findSubsequences(int[] nums) {
        set = new HashSet<>();
        findSubsequences(nums, 0, new LinkedList<>());
        return new ArrayList<>(set);
    }

    private void findSubsequences(int[] nums, int index, LinkedList<Integer> currList) {
        if (currList.size() >= 2) {
            set.add(new ArrayList(currList));
        }
        for (int i = index; i < nums.length; i++) {
            if (currList.isEmpty() || nums[i] >= currList.getLast()) {
                currList.add(nums[i]);
                findSubsequences(nums, i + 1, currList);
                currList.removeLast();
            }
        }
    }
}

// TC: O(n * 2^n)
// SC: O(n) -> Only hashset considered