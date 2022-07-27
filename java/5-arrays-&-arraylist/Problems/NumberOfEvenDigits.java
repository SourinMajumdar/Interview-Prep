// Problem link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/


class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int ele: nums){
            if(even(ele)) count++;
        }
        return count;
    }

    boolean even(int element){
        int numberOfDigits = (int)(Math.log10(element)) + 1;    // Returns the number of digits in the element
        if(numberOfDigits == 0) return false;
        else return numberOfDigits%2 == 0;
    }
}