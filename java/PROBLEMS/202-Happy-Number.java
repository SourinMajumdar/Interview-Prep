// Link: https://leetcode.com/problems/happy-number/description/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int curr = n;
            int sum = 0;

            while (curr > 0) {
                sum += (curr % 10) * (curr % 10);
                curr /= 10;
            }
            if (!set.add(sum)) {
                return false;
            }

            n = sum;
        }

        return true;
    }
}

// TC: O(N * k), SC: O(N)