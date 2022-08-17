// Link: https://leetcode.com/problems/count-primes/


// Brute force

class Solution {
    int count = 0;
    public int countPrimes(int n) {
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    public boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// TLE
// TC: O(n^2), SC: O(1)


// Sieve of Eratosthenes

class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];

        for (int i = 2; i * i < n; i++) {
            if (!primes[i]) {
                for (int j = i; j * i < n; j++) {
                    primes[j * i] = true;
                }
            }
        }

        int primeCount = 0;

        // Skipping first two values because 0 and 1 are not primes
        for (int i = 2; i < n; i++) {
            if(!primes[i]) primeCount++;
        }

        return primeCount;

    }
}
// TC: O(n * log (logn)) --> (https://leetcode.com/problems/count-primes/discuss/1086303/11-ms-Java-solution.-Sieve-of-Eratosthenes-algo.-Time-Complexity-explained)
// SC: O(n)



// OR

class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];

        // Initialising all indices value to true
        Arrays.fill(primes, true);      // O(n)

        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int j = i; j * i < n; j++) {
                    primes[j * i] = false;
                }
            }
        }

        int primeCount = 0;

        // Skipping first two values because 0 and 1 are not primes
        for (int i = 2; i < n; i++) {
            if(primes[i]) primeCount++;
        }

        return primeCount;

    }
}

// TC: O(n) + O(n * log (logn))



