// Link: https://practice.geeksforgeeks.org/problems/shreyansh-and-his-bits1420/1
// https://www.youtube.com/watch?v=STrodN3U_bk


class Solution{
    long[][]dp;

    long count(long n) {
        dp = new long[40][40];
        for (long[] row : dp) Arrays.fill(row, -1);

        int ones = 0, pos = 0;
        long ans = 0;

        while (n > 0){
            if((n & 1) == 1) {
                ones++;
                ans += nCr(pos, ones);
            }

            n >>= 1;
            pos++;
        }

        return ans;
    }

    long nCr(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (dp[n][r] != -1) return dp[n][r];
        return dp[n][r] = nCr(n - 1, r - 1) + nCr(n - 1, r);
    }
}


// -------------------------------------------------------------------------


class Solution {
    long nCr(int n,int r){
        long ans = 1;

        for (int i = 1; i <= r; i++){
            ans = ans * (n - r + i) / i;
        }

        return ans;
    }

    long count(long n){
        String s = Long.toBinaryString(n);
        int c = 0;
        long ans = 0;
        int ind = 0;

        for (int i = s.length() - 1; i >= 0; i--){
            ind++;

            if (s.charAt(i) == '1') {
                c++;

                if(ind != c){
                    ans += nCr(ind - 1, c);
                }
            }
        }

        return ans;
    }
}