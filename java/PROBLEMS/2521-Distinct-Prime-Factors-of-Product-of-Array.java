// Link: https://leetcode.com/problems/distinct-prime-factors-of-product-of-array/description/

class Solution {
    private Set<Integer> set = new HashSet<>();
    private void getPrimes(int num) {
        int n = num;
        for (int i = 2; i <= num; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                set.add(i);
            }
            if (n == 1) {
                return;
            }
        }
    }

    public int distinctPrimeFactors(int[] nums) {
        for (int n : nums) {
            getPrimes(n);
        }

        return set.size();
    }
}

// TC: O(n * k)
// n -> number of elements in nums
// k -> maximum element in nums