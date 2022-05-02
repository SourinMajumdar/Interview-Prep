import java.util.Scanner;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);

        //input using loop
        for (int i = 0; i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        //printing using for loop
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println();

        //printing using for each loop
        for(int ele: arr){
            System.out.print(ele+" ");
        }
    }
}
