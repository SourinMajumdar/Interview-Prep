// Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {

            if (nums[left] == target || nums[right] == target) {
                return true;

            } else if (target > nums[left]) {
                while (left < right && nums[left] == nums[left  + 1]) {
                    left++;
                }
                left++;

            } else if (target < nums[right]) {
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                right--;

            } else break;
        }

        return false;
    }
}

// TC: O(n), SC: O(1)

// Solution: https://www.youtube.com/watch?v=yPdfjEB8TvQ

class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) return true;

            // if left half is sorted
            if (nums[lo] < nums[mid]) {
                if (target < nums[lo] || target > nums[mid]) {  // if target lies in right half
                    lo = mid + 1;
                } else hi = mid - 1;

            // if left right is sorted
            } else if (nums[lo] > nums[mid]) {
                if (target < nums[mid] || target > nums[hi]) { // if target lies in left half
                    hi = mid - 1;
                } else lo = mid + 1;

            } else lo++;    // duplicate
        }

        return false;
    }
}

/*

TC: O(k) + O(log(n-K))


k in worst case can be k =n and in best case k =0
therefore worst case O(N) -- all elements are same
best case -- O (Logn) --- elements are different

SC: O(1)

*/