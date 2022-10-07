// Link: https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/

class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        Set<Integer> set1, set2;

        for (int i = 0; i < n; i++) {
            set1 = new HashSet<>();
            set2 = new HashSet<>();

            for (int j = 0; j < n; j++) {
                set1.add(matrix[i][j]);
                set2.add(matrix[j][i]);
            }

            if (set1.size() != n || set2.size() != n) {
                return false;
            }
        }

        return true;
    }
}

// TC: O(n * n), SC: O(n)