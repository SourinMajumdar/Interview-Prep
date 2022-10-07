/*
Problem link:
https://leetcode.com/problems/flipping-an-image/

Solution:
https://www.youtube.com/watch?v=qnd1WiutGio

*/

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for(int[] row : image) {
            int l = 0, r = n - 1;
            while(l <= r){
                if(row[l] == row[r]){
                    row[l] = 1 - row[l];
                    row[r] = row[l];
                }
                l++; r--;
            }
        }

        return image;
    }
}

// TC: O(n ^ 2)

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        // flipping
        for (int[] row : image) {
            int l = 0, r = n - 1;
            while (l < r) {
                int temp = row[l];
                row[l] = row[r];
                row[r] = temp;
                l++; r--;
            }
        }

        // inverting
        for (int[] row : image) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 0) row[j] = 1;
                else row[j] = 0;
            }
        }

        return image;
    }
}

// TC: 2 * O(n ^ 2) => O(n ^ 2)