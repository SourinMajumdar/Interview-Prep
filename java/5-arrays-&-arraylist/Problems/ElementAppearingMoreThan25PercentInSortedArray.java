package Problems;// Link: https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

class Solution {
    public int findSpecialInteger(int[] arr) {
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
                if (count >= arr.length / 4) return arr[i];
            }
            else count = 0;
        }

        return arr[0];
    }
}

// TC: O(n), SC: O(1)