/*

LEETCODE:
Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:
Input: nums = [12,345,2,6,7896]
Output: 2

Example 2:
Input: nums = [555,901,482,1771]
Output: 1

Problem link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

 */

class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int ele: nums){
            if(even(ele)) count++;
        }
        return count;
    }

    public boolean even(int element){
        //int len = Integer.toString(element).length(); -> takes 3-4 ms
        int len = (int)(Math.log10(element))+1; // takes 1 ms
        if(len==0) return false;
        else return len % 2 == 0;
    }
}