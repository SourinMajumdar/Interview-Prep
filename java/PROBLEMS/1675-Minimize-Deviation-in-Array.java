// Link: https://leetcode.com/problems/minimize-deviation-in-array/description/

class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) {
            set.add((n % 2 == 1)? n * 2 : n);
        }

        int minDiff = Integer.MAX_VALUE;
        while (true) {
            int min = set.first();
            int max = set.last();
            minDiff = Math.min(minDiff, max - min);
            if (max % 2 == 0) {
                set.remove(max);
                set.add(max / 2);
            } else {
                break;
            }
        }

        return minDiff;
    }
}

// TC: O(n * logn) + O(log(max) * logn)
// SC: O(n)