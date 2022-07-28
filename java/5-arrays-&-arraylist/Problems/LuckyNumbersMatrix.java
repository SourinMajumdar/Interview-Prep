/*
Problem link: https://leetcode.com/problems/lucky-numbers-in-a-matrix/
Solution: https://www.youtube.com/watch?v=TpW-oVqj6zk
 */

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<matrix.length; ++i){
            int minIndex = 0, min = Integer.MAX_VALUE;
            for(int j=0; j<matrix[i].length;++j){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    minIndex = j;
                }
            }
            // now min = matrix[i][minIndex]
            boolean isMax = true;
            for(int a=0; a<matrix.length; ++a){
                if(min < matrix[a][minIndex]){
                    isMax = false;
                    break;
                }
            }
            if(isMax){
                ans.add(min);
            }
        }
        return ans;
    }
}

// Time complexity: O(m*n)
// Space complexity: O(m) because worst case is when all rows will have a lucky number