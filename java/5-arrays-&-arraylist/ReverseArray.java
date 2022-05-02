import java.util.Arrays;

// Reverse an array
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(reverse(arr)));
    }
    static int[] reverse(int[] array){
//        using for loop
//        int start;
//        int end = array.length-1;
//        for (start=0; start < array.length/2; start++) {
//            swap(array,start, end);
//            end--;
//        }

        //using while
        int start = 0, end = array.length-1;
        while (start<end){
            swap(array,start,end);
            start++; end--;
        }
        return array;
    }
    static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }
}
