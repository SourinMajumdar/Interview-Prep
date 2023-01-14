// Link: https://leetcode.com/problems/find-the-distance-value-between-two-arrays/

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i : arr1) {
            boolean allDiffGreater = true;
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    allDiffGreater = false;
                    break;
                }
            }
            count += allDiffGreater? 1 : 0;
        }

        return count;
    }
}

// TC: O(m * n), SC: O(1)