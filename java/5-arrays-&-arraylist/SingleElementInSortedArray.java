// Problem: https://leetcode.com/problems/single-element-in-a-sorted-array/
// Solution: https://www.youtube.com/watch?v=4Gi8uAz666s

class Solution {
    public int singleNonDuplicate(int[] nums) {

        if (nums.length == 1) return nums[0];

        for (int i = 1; i < nums.length - 1; i += 2) {
            if(nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }

        return nums[nums.length - 1];
    }
}

// TC: O(n), SC: O(1)


// Using Binary Search

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while(lo < hi) {

            int mid = lo + (hi - lo) / 2;
            boolean isEven = (hi - mid) % 2 == 0;

            if (nums[mid] == nums[mid - 1]) {
                if (isEven) hi = mid - 2;
                else lo = mid + 1;

            } else if (nums[mid] == nums[mid + 1]) {
                if (isEven) lo = mid + 2;
                else hi = mid - 1;

            } else {
                return nums[mid];
            }

        }

        return nums[lo];
    }
}

// TC: O(logn), SC: O(1)