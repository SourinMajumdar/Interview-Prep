// Link: https://leetcode.com/problems/height-checker/

class Solution {
    public int heightChecker(int[] heights) {
        int[] h = new int[heights.length];
//        System.arraycopy(heights, 0, h, 0, heights.length);

        int i = 0;
        for (int n : heights) h[i++] = n;

        Arrays.sort(h);
        int count = 0;

        for (int j = 0; j < h.length; j++) {
            if (h[j] != heights[j]) count++;
        }

        return count;
    }
}

// TC: O(n) +  O(n * logn) + O(n) => O(n * logn)
// SC: O(n)


