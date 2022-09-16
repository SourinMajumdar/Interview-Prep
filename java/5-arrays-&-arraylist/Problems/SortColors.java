// Problem: https://leetcode.com/problems/sort-colors/
// Solution: https://www.youtube.com/watch?v=uvB-Ns_TVis

// Dutch National Flag algorithm
class Solution {
    public void sortColors(int[] nums) {
        int  lo = 0, hi = nums.length - 1, mid = 0;

        while (mid <= hi) {

            if (nums[mid] == 0) {
                nums[mid++] = nums[lo];
                nums[lo++] = 0;
            }

            else if (nums[mid] == 2) {
                nums[mid] = nums[hi];
                nums[hi--] = 2;
            }

            else mid++;
        }
    }
}

// TC: O(n), SC: O(1)


class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0;

        for (int n : nums) {
            if (n == 0) count0++;
            else if (n == 1) count1++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < count0) nums[i] = 0;
            else if (i < count0 + count1) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}

// TC: O(n), SC: O(1)


