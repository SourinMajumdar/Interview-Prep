// Link: https://leetcode.com/problems/rotate-image/
// Solution: https://www.youtube.com/watch?v=Y72QeX0Efxw

// Approach 1 (Using extra space):

// Takes the element column wise from below and puts them row wise
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        List<Integer> elements = new ArrayList<>();

        for (int col = 0; col < n; col++) {
            for (int row = n - 1; row >= 0; row--) {
                elements.add(matrix[row][col]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = elements.remove(0);
            }
        }
    }
}

// TC: O(n ^ 2), SC: O(n ^ 2)



// Approach 2 (No extra space):
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}

// TC: O(n ^ 2), SC: O(1)