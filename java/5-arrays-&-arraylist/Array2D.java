import java.util.Arrays;
import java.util.Scanner;

public class Array2D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = {
                        {1, 2, 3},      // 0th index
                        {4, 5},         // 1st index
                        {6, 7, 8, 9}    // 2nd index
                       };
        System.out.println(arr.length); //prints the number of rows
        for(int[] ele:arr){
            System.out.println(Arrays.toString(ele));
        }

        int[][] arr1 = new int[3][3]; // specifying the number of rows is mandatory
        
        //input using for loop
        for (int row = 0; row < arr.length; row++) {
            //for each column in every row
            for (int col = 0; col < arr1[row].length; col++) {
                arr1[row][col] = in.nextInt();
            }
        }
        // arr[row].length means the length of the particular array in that particular row
        // for loop will take input just like a 1D array. Because each index contains a 1D array itself

        //printing
        // using normal for loop
        for (int row = 0; row < arr1.length; row++) {
            for (int col = 0; col < arr1[row].length; col++) {
                System.out.print(arr1[row][col] +" ");
            }
            System.out.println();
        }

        // using toString() method
        for(int row = 0; row< arr.length; row++){
            System.out.println(Arrays.toString(arr1[row]));
        }

        // using for each loop
        for(int[] ele:arr1){
            System.out.println(Arrays.toString(ele));
        }

        for (int[] row : arr1) {
            for (int ele : row) System.out.print(ele + " ");
            System.out.println();
        }
    }
}

