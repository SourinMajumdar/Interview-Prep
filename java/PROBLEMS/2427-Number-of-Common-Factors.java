// Link: https://leetcode.com/problems/number-of-common-factors/

// Weekly 313, 2 Oct 2022
// Q1

class Solution {
    public int commonFactors(int a, int b) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                set.add(i);
            }
        }

        int count = 0;

        for (int i = 1; i <= a; i++) {
            if (b % i == 0) {
                if (set.contains(i)) {
                    count++;
                }
            }
        }

        return count;
    }
}

// TC: O(a + b), SC: O(a)


class Solution {
    public int commonFactors(int a, int b) {
        int count = 0;

        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }

        return count;
    }
}

// TC: O(min(a,b)), SC: O(1)