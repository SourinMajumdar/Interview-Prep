// https://leetcode.com/problems/pascals-triangle-ii/
// Solution: https://www.youtube.com/watch?v=CcVH6LAJp2M

// Brute force:

// create the whole triangle till that row and at the end return that last row
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currRow, prevRow = null;

        for (int i = 0; i <= rowIndex; i++) {
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

        return ans.get(rowIndex);
    }
}

// TC: O(n ^ 2), SC; O(n ^ 2)


// Memory optimized:

class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] ans = new Integer[rowIndex + 1];
        Arrays.fill(ans, 0);    // O(n)
        ans[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                ans[j] += ans[j - 1];
            }
        }

        return Arrays.asList(ans);
    }
}

// TC: O(n) + O(n ^ 2) => O(n ^ 2)
// SC: O(n)

// Optimal solution:
class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] ans = new Integer[rowIndex + 1];
        ans[0] = 1;

        for (int r = 1; r <= rowIndex; r++) {
            ans[r] = (int) ((long) ans[r - 1] * (rowIndex - r + 1) / r);
        }

        return Arrays.asList(ans);
    }
}

// TC: O(n), SC: O(n)

/*

nCr = nC(r - 1) * (n - r + 1) / r;

 */
