// Link: https://leetcode.com/problems/minimum-average-difference/

class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int minAvgDiff = Integer.MAX_VALUE, ans = -1;

        for (int i = 0; i < n; i++) {
            int leftAvg = 0;

            for (int left = 0; left <= i; left++) {
                leftAvg += nums[left];
            }

            leftAvg /= (i + 1);

            int rightAvg = 0;

            for (int right = i + 1; right < n; right++) {
                rightAvg += nums[right];
            }

            if (i != n - 1) rightAvg /= (n - i - 1);

            int currDiff = Math.abs(leftAvg - rightAvg);

            if (currDiff < minAvgDiff) {
                minAvgDiff = currDiff;
                ans = i;
            }
        }

        return ans;
    }
}

// TC: O(n ^ 2), SC: O(1)


class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        long[] suffix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }

        int minAvgDiff = Integer.MAX_VALUE;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            long leftAvg = prefix[i + 1] / (i + 1);
            long rightAvg = (i != n - 1)? suffix[i + 1] / (n - i - 1) : 0;

            int currDiff = (int) Math.abs(leftAvg - rightAvg);

            if (currDiff < minAvgDiff) {
                minAvgDiff = currDiff;
                ans = i;
            }
        }

        return ans;
    }
}

// TC: 3 * O(n) => O(n)
// SC: 2 * O(n) => O(n)




class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int ans = -1, minAvgDiff = Integer.MAX_VALUE;

        long totalSum = 0;
        for (int i : nums) totalSum += i;

        long currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += nums[i];

            long leftAvg = currSum / (i + 1);
            long rightAvg = (i != n - 1)? (totalSum - currSum) / (n - i - 1) : 0;

            int currDiff = (int) Math.abs(leftAvg - rightAvg);

            if (currDiff < minAvgDiff) {
                minAvgDiff = currDiff;
                ans = i;
            }
        }

        return ans;
    }
}

// TC: 2 * O(n) => O(n)
// SC: O(1)