/*
Guess number higher or lower
https://leetcode.com/problems/guess-number-higher-or-lower/
 */

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 0, end = n;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(guess(mid)==0) return mid;
            else if(guess(mid)==1) start = mid+1;
            else end = mid-1; // guess(mid)==1
        }
        return -1;
    }
}