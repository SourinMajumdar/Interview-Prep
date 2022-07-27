/*
Problem link:
https://leetcode.com/problems/flipping-an-image/

Solution:
https://www.youtube.com/watch?v=qnd1WiutGio

*/

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i<A.length; ++i){
            int low = 0;
            int high = A[i].length - 1;

            while(low <= high){
                if(A[i][low] == A[i][high]){
                    A[i][low] = 1 - A[i][low];
                    A[i][high] = A[i][low];
                }
                low++; high--;
            }
        }
        return A;
    }
}