// https://www.youtube.com/watch?v=F5MZyqRp_IM&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=17

// BUBLE SORT

import java.util.*;
class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 3, 8, 94, 4, 0, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }

            if (!swapped) break;
        }
    }
}

// TC:
// Best Case: O(n)
// Worst Case: O(n^2)

// SC: O(1)