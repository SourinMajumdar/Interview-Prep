// Link: https://leetcode.com/problems/closest-prime-numbers-in-range/description/

// Weekly 326, 1 Jan 2023
// Q4

class Solution {
    private List<Integer> primes = new ArrayList<>();
    private void sieve(int l, int r) {
        boolean[] p = new boolean[r+1];
        Arrays.fill(p, true);

        for (int i = 2; i * i <= r; i++) {
            if (!p[i]) continue;
            for (int j = 2 * i; j <= r; j += i) {
                p[j] = false;
            }
        }
        p[0] = p[1] = false;

        // adding the primes only within the given range
        for (int i = l; i <= r; i++) {
            if (p[i]) primes.add(i);
        }
    }

    public int[] closestPrimes(int left, int right) {
        sieve(left, right);
        int a = -1, b = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < primes.size(); i++) {
            int currDiff = primes.get(i) - primes.get(i-1);
            if (minDiff > currDiff) {
                minDiff = currDiff;
                a = primes.get(i-1);
                b = primes.get(i);
            }
        }

        return new int[] {a, b};
    }
}

// TC: O(right * log(log(right)) + O(right - left)
// SC: O(right) + O(right - left)
