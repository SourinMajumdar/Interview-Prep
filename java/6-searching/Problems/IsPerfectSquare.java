/*
Valid Perfect Square:

Given a positive integer num, write a function which returns True if num is a perfect square else False.
Follow up: Do not use any built-in library function such as sqrt.

https://leetcode.com/problems/valid-perfect-square/submissions/

 */

class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<2) return true;
        long start= 2, end = num-1;
        while (start <= end) {
            long mid = start +(end-start)/2;

            if (mid*mid == num) return true;
            if (mid*mid < num) start = mid + 1;
            else end = mid - 1; // mid*mid > num
        }
        return false;
    }
}
