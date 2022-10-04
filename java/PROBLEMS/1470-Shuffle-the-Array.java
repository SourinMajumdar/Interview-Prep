// Link: https://leetcode.com/problems/shuffle-the-array/

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int i = 0, j = n;
        int idx = 0;

        while (i <= n && j < 2 * n) {
            if (idx % 2 == 0) {
                ans[idx++] = nums[i++];
            }
            else ans[idx++] = nums[j++];
        }

        return ans;
    }
}

// TC: O(n)

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];

        for(int i = 0; i<n; i++){
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[n + i];
        }

        return ans;
    }
}

// TC: O(n)