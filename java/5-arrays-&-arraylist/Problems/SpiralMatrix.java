/*
After we traverse a row:
        If top row -> increase value by one and move to next row
        if bottom row -> decrease value by one and move to previous row


After we traverse a column:
        If its left column -> Increase value by one and move to previous column
        if its right column -> decrease value by one and move to previous column
*/



class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        int leftCol = 0, rightCol = col - 1;
        int topRow = 0, bottomRow = row - 1;
        int d = 0;

        while (leftCol <= rightCol && topRow <= bottomRow){

            if(d == 0) { // direction left to right
                for (int i = leftCol; i <= rightCol; ++i){
                    arr.add(matrix[topRow][i]);
                }
                d = 1; topRow++;
            } else if (d == 1) { // direction top to bottom
                for (int i = topRow; i <=  bottomRow; ++i){
                    arr.add(matrix[i][rightCol]);
                }
                d = 2; rightCol--;
            } else if (d == 2) {   // direction right to left
                for (int i = rightCol; i >= leftCol; i--){
                    arr.add(matrix[bottomRow][i]);
                }
                d = 3; bottomRow--;
            } else if (d == 3) {   // direction bottom to top
                for (int i = bottomRow; i >= topRow; i--){
                    arr.add(matrix[i][leftCol]);
                }
                d = 0; leftCol++;
            }
        }

        return arr;
    }
}


