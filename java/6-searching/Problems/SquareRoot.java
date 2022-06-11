/*
Sqrt(x)
Given a non-negative integer x, compute and return the square root of x.

https://leetcode.com/problems/sqrtx/
 */

class Solution {
    public int mySqrt(int x) {
        if(x==1) return x;
        int start = 2, end = x/2;
        long num;
        while(start<=end){
            int mid = start+(end-start)/2;
            num = (long)mid*mid;
            if(num>x) end = mid-1;
            else if (num<x) start = mid+1;
            else return mid; // num == x
        }
        return end;
    }
}