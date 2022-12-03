// Link: https://practice.geeksforgeeks.org/problems/aggressive-cows/1
// https://www.youtube.com/watch?v=wSOfYesTBRk


class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);

        int lo = 1, hi = stalls[n - 1] - stalls[0];
        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canPlaceCows(stalls, n, k, mid)) {
                ans = mid;
                lo = mid + 1;
            }
            else hi = mid - 1;
        }

        return ans;
    }

    static boolean canPlaceCows(int[] arr, int n, int cows, int dist) {
        int pos = arr[0], placedCows = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] - pos >= dist) {
                pos = arr[i];
                placedCows++;
            }
            if (placedCows == cows) return true;
        }

        return false;
    }
}

// TC: O(n * logn), SC: O(1)