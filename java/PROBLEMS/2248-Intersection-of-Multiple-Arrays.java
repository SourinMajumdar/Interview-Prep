// Link: https://leetcode.com/problems/intersection-of-multiple-arrays/
// Solution: https://www.youtube.com/watch?v=lAuhcsiZfhU

class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] freq = new int[1001];

        for (int[] row : nums) {
            for (int n : row) {
                freq[n]++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == nums.length) {
                ans.add(i);
            }
        }

        return ans;
    }
}

// TC: O(m * n), SC: O(1) - ignoring the output array