// Link: https://leetcode.com/problems/guess-number-higher-or-lower/

// Brute force (TLE)

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (guess(i) == 0) {
                ans = i;
            }
        }

        return ans;
    }
}

// TC: O(n)

// Binary Search
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int res = guess(mid);

            if (res == 0) return mid;
            else if (res == -1) hi = mid - 1;
            else if (res == 1) lo = mid + 1;
        }

        return 0;
    }
}

// TC: O(logn)