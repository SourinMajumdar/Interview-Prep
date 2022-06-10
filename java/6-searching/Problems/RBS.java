// https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(pivot==-1)return BS(nums,target,0,nums.length-1);    //no pivot found, means the array is not rotated (so just do normal bs)
        // if pivot is foun, we have 2 asc sorted arrays
        if(target==nums[pivot]) return pivot;                   // if target = pivot, return the pivot
        if(target>=nums[0]) return BS(nums, target, 0, pivot);
        else return BS(nums,target, pivot+1, nums.length-1);
    }

    int findPivot(int[] arr){
        int start = 0, end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1]) return mid;  /

            if(mid>start && arr[mid]<arr[mid-1]) return mid-1;
            if(arr[start]>arr[mid]) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }

    int BS(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<arr[mid]){end = mid-1;}
            else if(target>arr[mid]){start = mid+1;}
            else return mid;
        }
        return -1;
    }
}

// this wont work for duplicate values