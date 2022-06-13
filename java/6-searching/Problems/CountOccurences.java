/*
Number of occurrence:
Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.
https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1/#
 */

class Solution {
    int count(int[] arr, int n, int target) {
        int[] ans = {-1,-1};
        ans[0] = search(arr, n, target, true);
        if(ans[0]!=-1) {
            ans[1] = search(arr, n, target, false);
            return ans[1]-ans[0]+1;
        }
        return 0;
    }

    int search(int[] arr, int n, int target, boolean findStartIndex){
        int ans = -1;
        int start = 0, end = n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<arr[mid]) end = mid-1;
            else if (target>arr[mid]) start = mid+1;
            else{
                ans = mid;
                if(findStartIndex) end = mid-1;
                else start = mid+1;
            }
        }
        return ans;
    }
}
