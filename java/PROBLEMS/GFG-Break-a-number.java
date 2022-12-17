// Link: https://practice.geeksforgeeks.org/problems/break-a-number5913/1


class Solution{
    int waysToBreakNumber(int N){
        int mod = 1000000007;
        int ans = 0;

        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= N; j++)
                for (int k = 0; k <= N; k++)
                    if (i + j + k == N) {
                        ans = ans % mod + 1;
                    }

        return ans;
    }
}

// TC: O(n ^ 3)


class Solution{
    int waysToBreakNumber(int n){
        long mod = 1000000007;
        long ans = ((n + 1)%mod * (n + 2)%mod)%mod / 2;
        return (int) ans;
    }
}

// TC: O(1)
