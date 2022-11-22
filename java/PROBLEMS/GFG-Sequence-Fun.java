// Link: https://practice.geeksforgeeks.org/problems/sequence-fun5018/1?page=1&category[]=pattern-printing&sortBy=submissions

class Solution {
    public int NthTerm(int n) {
        int mod = 1000000000 + 7;
        long ans = 1;

        for (int i = 1; i <= n; i++) {
            ans = (ans * i + 1) % mod;
        }

        return (int) ans;
    }
}