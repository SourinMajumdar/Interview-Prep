// Link: https://leetcode.com/contest/biweekly-contest-90/problems/next-greater-element-iv/

// biweekly 90, 29 Oct 2022
// Q4

// Brute force (TLE - 45/50 passed)

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int second = -1;
            boolean firstGreaterFound = false;

            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    if (!firstGreaterFound) {
                        firstGreaterFound = true;
                    }
                    else {
                        second = nums[j];
                        break;
                    }
                }
            }

            ans[i] = second;
        }

        return ans;
    }
}

// TC: O(n) + O(n ^ 2) => O(n ^ 2)
// SC: O(n)


