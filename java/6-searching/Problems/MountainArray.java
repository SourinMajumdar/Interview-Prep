/*

LEETCODE:
Let's call an array arr a mountain if the following properties hold:

- arr.length >= 3
- There exists some i with 0 < i < arr.length - 1 such that:
- arr[0] < arr[1] < ... arr[i-1] < arr[i]
- arr[i] > arr[i+1] > ... > arr[arr.length - 1]

Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

Example 1:
Input: arr = [0,1,0]
Output: 1

Example 2:
Input: arr = [0,2,1,0]
Output: 1

Example 3:
Input: arr = [0,10,5,2]
Output: 1

Problem link: https://leetcode.com/problems/peak-index-in-a-mountain-array/

 */


class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid]>arr[mid+1]) end = mid;  // means we are in decreasing part of array. so arr[mid] becomes the end element coz we don't need to check beyond that coz peak lies before/at end
            else start = mid+1; // if arr[mid]<arr[mid+1] : means we are in increasing part of array. start is moved forward in array. we know mid is less than mid+1 so no need to include mid in the next sub-array. directly start from mid+1 which is new start
        }
        // process will continue till start is just less than end, right when start becomes equal to end, loop breaks. start and end points to the same element therefore that element is the peak
        return start; // or return end
    }
}

/*
So, if mid > mid+1, mid is end. no need to check beyond that (decreasing part)
if mid < mid+1 (else), mid+1 becomes start, no need to check before that
finally after coming from both sides, start and end overlap, which gives the peak

 */