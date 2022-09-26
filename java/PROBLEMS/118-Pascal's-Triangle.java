// Link: https://leetcode.com/problems/pascals-triangle/
// Solution: https://www.youtube.com/watch?v=6FLvhQjZqvM&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=9

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currRow, prevRow = null;

        for (int i = 0; i < numRows; i++) {
            currRow = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) currRow.add(1);
                else {
                    currRow.add(
                        prevRow.get(j - 1) + prevRow.get(j)
                    );
                }
            }

            ans.add(currRow);
            prevRow = currRow;
        }

        return ans;
    }
}

// TC: O(n ^ 2), SC: O(n ^ 2)

/*
The number in the R-th row and C-th column in a pascal's triangle is given by :

        (R - 1)C(C - 1)     or  C(R - 1, C - 1);

 */