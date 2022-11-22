// Link: https://practice.geeksforgeeks.org/problems/print-pattern3549/1?page=1&category[]=pattern-printing&sortBy=submissions

class Solution{
    static List<Integer> solve(int N, List<Integer> ans) {
        if(N < 1) {
            ans.add(N);
            return ans;
        }

        ans.add(N);
        solve(N - 5, ans);
        ans.add(N);

        return ans;
    }

    static List<Integer> pattern(int N) {
        List<Integer> ans = new ArrayList<>();
        return solve(N, ans);
    }
}