// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        // store the element and its 1-bits count
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = Integer.bitCount(arr[i]);
            a[i][1] = arr[i];
        }

        // Sort in increasing order of number of 1 bits
        // if number of 1 bits is same,
        // sort in increasing order of the element itself
        Arrays.sort(a, (x, y) ->
            (x[0] == y[0])? (x[1] - y[1]) : (x[0] - y[0])
        );

        // put the sorted elements back to the given array
        for (int i = 0; i < n; i++) {
            arr[i] = a[i][1];
        }

        return arr;     // return the array
    }
}

// TC: O(n + n * logn + n) => O(n * logn)
// SC: O(2n) => O(n)

class Solution {
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }

        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++) {
            arr[i] %= 10001;
        }

        return arr;
    }
}

// TC: O(n + n * logn + n) => O(n * logn)
// SC: O(1)