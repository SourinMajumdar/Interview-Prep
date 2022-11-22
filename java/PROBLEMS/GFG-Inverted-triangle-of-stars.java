// Link: https://practice.geeksforgeeks.org/problems/inverted-triangle-of-stars0110/1?page=1&category[]=pattern-printing&sortBy=submissions

class Solution {
    static String[] invIsoTriangle(int N) {
        String[] ans = new String[N];

        char[] stars = new char[2 * N - 1];
        Arrays.fill(stars, '*');

        for (int i = 0; i < N; i++) {
            ans[i] = String.valueOf(stars);
            stars[i] = ' ';
            stars[stars.length - i - 1] = ' ';  // or stars[2 * N - i - 2]
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)