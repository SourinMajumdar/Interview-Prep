// Link: https://leetcode.com/problems/find-the-pivot-integer/

// weekly 321, 27 Nov 2022
// Q1

class Solution {
    public int pivotInteger(int n) {
        int[] left = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = i + 1;
        }

        for (int i = 1; i < n; i++) {
            left[i] += left[i - 1];
        }

        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            right[i] = i + 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] += right[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (left[i] == right[i]) {
                return i + 1;
            }
        }

        return -1;
    }
}



class Solution {
    public int pivotInteger(int n) {
        int[] left = new int[n];
        left[0] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + i + 1;
        }

        int[] right = new int[n];
        right[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            right[i] += right[i + 1] + i + 1;
        }

        for (int i = 0; i < n; i++) {
            if (left[i] == right[i]) {
                return i + 1;
            }
        }

        return -1;
    }
}


class Solution {
    public int pivotInteger(int n) {
        int k = n * (n + 1) / 2;

        for (int i = 1; i <= n; i++) {
            if (i * i == k) return i;
        }

        return -1;
    }
}


class Solution {
    public int pivotInteger(int n) {
        int leftSum = 0;
        int sum = n * (n + 1) / 2;

        for (int i = 1; i <= n; i++) {
            leftSum += i;
            int rightSum = sum - leftSum + i;

            if (leftSum == rightSum) return i;
        }

        return -1;
    }
}


