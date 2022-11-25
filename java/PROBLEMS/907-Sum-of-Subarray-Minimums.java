// Link: https://leetcode.com/problems/sum-of-subarray-minimums/

// 77/87
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                int min = Integer.MAX_VALUE;

                for (int k = j; k <= i; k++) {
                    min = Math.min(min, arr[k]);
                }

                sum += min;
            }
        }

        return (int) (sum % 1000000007);
    }
}

// TC: O(n ^ 3), SC: O(1)


// 84/87
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            sum += min;

            for (int j = i + 1; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
            }
        }

        return (int) (sum % 1000000007);
    }
}

// TC: O(n ^ 2), SC: O(1)