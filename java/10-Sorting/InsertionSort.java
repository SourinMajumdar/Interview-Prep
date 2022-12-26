// https://www.youtube.com/watch?v=By_5-RRqVeE&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=19

import java.util.*;
class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 100, 8, 1, 0, -6, 3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j-1] <= arr[j]) {
                    break;
                }
                // swap
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }
}


// TC:
// Worst case: O(n^2)
// Best Case: O(n)

// SC: O(1)