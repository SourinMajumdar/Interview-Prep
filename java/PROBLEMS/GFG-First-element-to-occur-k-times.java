// Link: https://practice.geeksforgeeks.org/problems/first-element-to-occur-k-times5150/

class Solution {
    public int firstElementKTime(int[] a, int n, int k) {
        int[] freq = new int[100001];

        for (int i : a) {
            freq[i]++;
            if (freq[i] == k) return i;
        }

        return -1;
    }
}

// TC: O(n), SC: O(1)