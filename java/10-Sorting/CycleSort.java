// https://www.youtube.com/watch?v=JfinxytTYFQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=20

import java.util.*;
class CycleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 2};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIdx = arr[i] - 1;
            if (arr[i] != arr[correctIdx]) {
                // swap
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            }
            else i++;
        }
    }
}

// TC: O(n) + O(n - 1) ~ O(n)
// SC: O(1)