// Link: https://leetcode.com/problems/valid-sudoku/
// Solution: https://www.youtube.com/watch?v=Ru_kyDIE6XI

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char n = board[i][j];

                if (n != '.') {
                    if (set.contains(n + "r" + i) || set.contains(n + "c" + j)
                        || set.contains(n + "b" + i / 3 + j / 3)) {
                        return false;
                    }

                    set.add(n + "r" + i);
                    set.add(n + "c" + j);
                    set.add(n + "b" + i / 3 + j / 3);
                }
            }
        }

        return true;
    }
}

// TC: O(9 ^ 2) => O(1)
// SC: O(

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char n = board[i][j];

                if (n != '.') {
                    if (!set.add(n + "r" + i) ||
                        !set.add(n + "c" + j) ||
                        !set.add(n + "b" + i / 3 + j / 3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}