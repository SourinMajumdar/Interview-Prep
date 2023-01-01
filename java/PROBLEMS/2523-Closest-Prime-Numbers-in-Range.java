// Link: https://leetcode.com/problems/closest-prime-numbers-in-range/description/

// Weekly 326, 1 Jan 2023
// Q4

class Solution {
    private List<Integer> primes = new ArrayList<>();
    private void sieve(int n) {
        boolean[] notPrime = new boolean[n+1];
        for (int p = 2; p * p <= n; p++) {
            if (!notPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    notPrime[i] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!notPrime[i]) {
                primes.add(i);
            }
        }
    }

    public int[] closestPrimes(int left, int right) {
        sieve(right);
        int minDiff = Integer.MAX_VALUE;
        int v1 = -1, v2 = -1;
        int i = 0;

        for (i = 0; i < primes.size(); i++) {
            if (primes.get(i) >= left) {
                break;
            }
        }

        for (int j = i + 1; j < primes.size(); j++) {
            int currDiff = primes.get(j) - primes.get(j - 1);
            if (currDiff < minDiff) {
                minDiff = currDiff;
                v1 = primes.get(j - 1);
                v2 = primes.get(j);
            }
        }

        return new int[] {v1, v2};
    }
}

