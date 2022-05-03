import java.util.Arrays;

public class MaxIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {5,7,8},
                {45,87,12,6},
                {33,21},
                {11,3,69,420,100}
        };
        System.out.println(max(arr));
    }

    static int max(int[][] arr){
        int max = arr[0][0];
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt > max) max = anInt;
            }
        }
        return max;

        //using for each loop
//        int max = Integer.MIN_VALUE;
//        for (int[] rows : arr) {
//            for (int ele: rows) {
//                if(ele>max) max=ele;
//            }
//        }
//        return max;
    }
}
