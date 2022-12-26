// https://www.youtube.com/watch?v=Nd4SCCIHFWk&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=19


import java.util.*;
class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 100, 8, 1, 0, -6, 3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lastIdx = arr.length - i - 1;

            // find index of max element
            int maxIdx = 0;
            for (int j = 0; j <= lastIdx; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            // swap last position with max element
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[lastIdx];
            arr[lastIdx] = temp;
        }
    }
}

// TC: O(n^2), SC: O(1)