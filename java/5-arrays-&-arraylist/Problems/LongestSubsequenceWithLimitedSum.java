// Link: https://leetcode.com/problems/longest-subsequence-with-limited-sum/
// Solution: https://www.youtube.com/watch?v=vpWBTmazGjU

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int maxLength = n;

            for (int j = 0; j < n; j++) {
                if (nums[j] > queries[i]) {
                    maxLength = j;
                    break;
                }
            }
            ans[i] = maxLength;
        }

        return ans;
    }
}

// TC: O(n *logn) + O(m * n)
// SC: O(m)