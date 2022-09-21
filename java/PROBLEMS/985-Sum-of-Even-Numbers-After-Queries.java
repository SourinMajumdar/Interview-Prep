// Link: https://leetcode.com/problems/sum-of-even-numbers-after-queries/

// Brute force (TLE)

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < queries.length; i++) {
            int value = queries[i][0];
            int index = queries[i][1];

            nums[index] += value;
            int sum = 0;

            for (int n : nums) {
                if (n % 2 == 0) sum += n;
            }

            ans[i] = sum;
        }

        return ans;
    }
}

// TC: O(n * m),
// SC: O(n) - if output array considered otherwise O(1)


// Optimal solution:
class Solution {

    // the idea is we don't calculate the even sum from scratch for each query
    // instead, we calculate it at the beginning
    // since each query only updates one value,
    // so we can adjust the even sum base on the original value and new value

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[nums.length];
        int evenSum = 0;

        for (int n : nums) {                                // calculate the sum of all even numbers
            if (n % 2 == 0) evenSum += n;
        }

        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0], idx = queries[i][1];

            if (nums[idx] % 2 == 0) evenSum -= nums[idx];   // if original nums[idx] is even, then we deduct it from evenSum

            nums[idx] += val;                               // in-place update nums

            if (nums[idx] % 2 == 0) evenSum += nums[idx];   // check if we need to update evenSum for the new value

            ans[i] = evenSum;                               // then we have evenSum after this query, push it to ans
        }

        return ans;
    }
}

// TC: O(n) + O(m)
// SC: O(n) - if output array considered otherwise O(1)

