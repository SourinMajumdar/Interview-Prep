// Link: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] == b[1]? a[0] - b[0] : a[1] - b[1]
        );

        for (int i = 0; i < mat.length; i++) {
            int ct = 0;
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    ct = j + 1;
                    break;
                }
            }
            pq.offer(new int[] {i, ct});
        }

        int[] ans = new int[k];
        while (k-- > 0) {
            ans[ans.length-k-1] = pq.poll()[0];
        }

        return ans;
    }
}

// TC: O(n * (n + logn)) + O(k * logn) => O(n^2)
// SC: O(n + k)

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] == b[1]? a[0] - b[0] : a[1] - b[1]
        );

        for (int i = 0; i < mat.length; i++) {
            int l = 0, r = mat[0].length - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (mat[i][m] == 0) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            pq.offer(new int[] {i, l});
        }

        int[] ans = new int[k];
        while (k-- > 0) {
            ans[ans.length-k-1] = pq.poll()[0];
        }

        return ans;
    }
}

// TC: O(n * logn) + O(k * logn), SC: O(n)