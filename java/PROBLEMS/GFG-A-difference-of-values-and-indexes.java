// Link: https://practice.geeksforgeeks.org/problems/a-difference-of-values-and-indexes0302/1
// https://leetcode.com/discuss/interview-question/749936/maximum-absolute-difference-amazon

class Solution{
    public static int maxDistance (int arr[], int n) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        int i = 0;
        for (int x : arr) {
            max1 = Math.max(max1, x + i);
            min1 = Math.min(min1, x + i);

            max2 = Math.max(max2, x - i);
            min2 = Math.min(min2, x - i++);
        }

        int diff1 = max1 - min1;
        int diff2 = max2 - min2;

        return Math.max(diff1, diff2);
    }
}

// TC: O(n), SC: O(1)