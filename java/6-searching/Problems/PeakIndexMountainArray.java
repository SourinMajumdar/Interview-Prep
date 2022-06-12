/*
Find peak index in mountain array
https://leetcode.com/problems/peak-index-in-a-mountain-array/

Example 1:
Input: arr = [0,1,0]
Output: 1

Example 2:
Input: arr = [0,2,1,0]
Output: 1

Example 3:
Input: arr = [0,10,5,2]
Output: 1

 */


class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid]>arr[mid+1]){ // descending part of array
                end = mid; // if true, end=mid, we'll check till this new end
            }else{ // arr[mid]>arr[mid+1], ascending part of array
                start = mid+1; // we'll check from mid+1 coz mid is definitely smaller than mid+1
            }
        }
        return start; // or end
        // because at the end, start and end both will point to the same element which will be the peak
    }
}