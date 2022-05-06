/*

LEETCODE:
You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

Example 1:
Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.

Example 2:
Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.

Problem link: https://leetcode.com/problems/find-in-mountain-array/

*/

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int start = 0, end = arr.length()-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr.get(mid)>arr.get(mid+1)) end = mid;
            else start = mid+1;
        }
        // the above code block will find me the peak element - start/end is the peak

        int peak = start;
        int firstTry = orderAgnostic(arr, target, 0, peak);     // will search the target in the ascending part
        if(firstTry!=-1) return firstTry;                           // if found, it will return it
        return orderAgnostic(arr, target, peak, arr.length()-1);    // else it will search the target in the descending part
        // the order agnostic function will figure out itself that if it is ascending part or descending part
    }

    int orderAgnostic(MountainArray arr, int target, int start, int end){   // we will provide the start and end indexes to tell it in which area to search in
        boolean isAsc = arr.get(start)<arr.get(end);
        while(start<=end){
            int mid = start +(end-start)/2;
            if(arr.get(mid)==target) return mid;
            if(isAsc){
                if(target>arr.get(mid)) start = mid+1;
                else end = mid-1;
            }else{
                if(target>arr.get(mid)) end = mid-1;
                else start = mid+1;
            }
        }
        return -1;
    }
}