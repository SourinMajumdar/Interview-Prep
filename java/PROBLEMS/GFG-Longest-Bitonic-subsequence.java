// Link: https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1

class Solution {
    public int LongestBitonicSequence(int[] nums) {
        int n = nums.length;

        int[] lis = new int[n];

        for (int i = 0; i < n; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lis[j] > max) max = lis[j];
                }
            }

            lis[i] = max + 1;
        }

        int[] lds = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int max = 0;

            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    if (lds[j] > max) max = lds[j];
                }
            }

            lds[i] = max + 1;
        }

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            maxLen = Math.max(lis[i] + lds[i] - 1, maxLen);
        }

        return maxLen;
    }
}

// TC: O(n^2 + n^2) => O(n ^ 2)
// SC: O(n + n) => O(n)