/*
Problem link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
Solution:
 */


// Two pointers
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l <= r) {
            int sum = numbers[l] + numbers[r];

            if (sum > target) r--;
            else if (sum < target) l++;
            else return new int[]{l + 1, r + 1};
        }

        return new int[]{-1, -1};       // is never reached
    }
}
// TC: O(n), SC: O(1)



// Binary Search
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int lo = i + 1, hi = numbers.length - 1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int sum = numbers[i] + numbers[mid];

                if (sum > target) {
                    hi = mid - 1;
                }
                else if (sum < target) {
                    lo = mid + 1;
                }

                else return new int[]{i + 1, mid + 1};
            }
        }

        return new int[]{};
    }
}

// TC: O(n * logn), SC: O(1)