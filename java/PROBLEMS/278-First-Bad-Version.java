// Link: https://leetcode.com/problems/first-bad-version/


// Brute force - TLE

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i)) return i;
        }

        return 0;
    }
}

// TC: O(n)



public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (!isBadVersion(mid)) lo = mid + 1;
            else hi = mid;
        }

        return hi;
    }
}

// TC: O(logn)