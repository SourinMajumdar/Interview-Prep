import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {5,7,8},
                {45,87,12,6},
                {33,21},
                {11,3,69,420,100}
        };
        int target = 69;
        int[] ans = search(arr, target); // format is int {row,col}
        System.out.println(Arrays.toString(ans));
    }

    static int[] search(int[][] arr, int target){
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col]==target) return new int[]{row+1,col+1};
            }
        }
        return new int[]{-1,-1};
    }
}
