// Link: https://leetcode.com/problems/numbers-with-same-consecutive-differences/
// Solution:
// https://www.youtube.com/watch?v=TAfXh2l9FyA&t=686s
// https://www.youtube.com/watch?v=0BbZQ3SmWAE

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> result = new ArrayList<>();
        for (int num = 1; num < 10; num++) {
            dfs(n - 1, num, k, result);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public void dfs(int n, int num, int k, List<Integer> res) {
        if (n == 0) {
            res.add(num);
            return;
        }

        int lastDigit = num % 10;
        // if k > lastDigit, subtraction will become negative
        if (lastDigit >= k) dfs(n - 1, num * 10 + lastDigit - k, k, res);
        if (k > 0 && lastDigit + k < 10) dfs(n - 1, num * 10 + lastDigit + k, k, res);
    }
}

// TC: O(n * 2^n)
// SC: O(n) + O(n * 2^n) => O(n * 2^n)