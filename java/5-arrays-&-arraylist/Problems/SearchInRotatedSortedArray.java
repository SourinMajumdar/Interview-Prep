// Link: https://leetcode.com/problems/search-in-rotated-sorted-array/


// Kunal Kushwaha's solution:
class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(pivot == -1) return BS(nums, target, 0, nums.length-1);
        if(target == nums[pivot]) return pivot;
        if(target >= nums[0]) return BS(nums, target, 0, pivot);
        else return BS(nums, target, pivot+1, nums.length-1);
    }

    int findPivot(int[] arr){
        int start = 0, end = arr.length-1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid+1]) return mid;
            if(mid > start && arr[mid] < arr[mid-1]) return mid - 1;
            if(arr[start] > arr[mid]) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }

    int BS(int[] arr, int target, int start, int end) {
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target < arr[mid]) end = mid - 1;
            else if(target > arr[mid]) start = mid + 1;
            else return mid;
        }

        return -1;
    }
}


// Striver's solution (https://www.youtube.com/watch?v=r3pMQ8-Ad5s)

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) return mid;

            // if left half is sorted
            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target <= nums[mid])
                    hi = mid - 1;
                else lo = mid + 1;

                // if right half is sorted
            } else {

                if (target >= nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else hi = mid - 1;
            }
        }

        return -1;
    }
}

// TC: O(logn), SC: O(1)