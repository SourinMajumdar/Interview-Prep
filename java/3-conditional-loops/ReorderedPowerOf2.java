// Link: https://leetcode.com/problems/reordered-power-of-2/
// Problems.Problems.Problems.Problems.Solution: https://www.youtube.com/watch?v=PBf1qzkN6z8

class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] countN = count(n);
        int num = 1;

        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(countN, count(num))) {
                return true;
            }
            num *= 2;
        }

        return false;
    }

    int[] count(int N) {
        int[] arr = new int[10];
        while (N > 0) {
            arr[N % 10]++;
            N /= 10;
        }

        return arr;
    }
}