// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

class Solution {
    public int findMin(int[] nums) {
        int pivot = findPivotWithDuplicates(nums);
        if(pivot==-1){return nums[0];}
        return nums[pivot+1];
    }

    int findPivotWithDuplicates(int[] arr){
        int start = 0, end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1]) return mid;
            if(mid>start && arr[mid]<arr[mid-1]) return mid-1;

            // if elements at start, mid, end are equal, then just skip the duplicates
            if(arr[start]==arr[mid] && arr[end]==arr[mid]){
                // check if start is pivot
                if(start<end && arr[start]>arr[start+1]) return start;
                start++;

                //check if end is pivot
                if(start<end && arr[end]<arr[end-1]) return end-1;
                end--;
            }
            // left side has bigger elements, min will be in the right eg.: [3,4,5,1,2]
            else if(arr[start]<=arr[mid] && arr[mid]>arr[end]) start=mid+1;
            else end = mid-1;
        }
        return -1;
    }
}
