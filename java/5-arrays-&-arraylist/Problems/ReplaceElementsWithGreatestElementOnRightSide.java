// Link: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

// 1. Using function
class Solution {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];

        for (int i = 0; i < ans.length - 1; i++) {
            ans[i] = maxInRight(arr, i + 1, ans.length - 1);
        }

        ans[arr.length - 1] = -1;
        return ans;
    }

    int maxInRight(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}

// ---------------------------------------------------------

// 2. Using nested for loop

class Solution {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];

        for (int i = 0; i < ans.length - 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < ans.length; j++) {
                max = Math.max(max, arr[j]);

            }
            ans[i] = max;
        }
        ans[arr.length - 1] = -1;
        return ans;
    }
}

// TC: O(n^2), SC: O(n)

// ----------------------------------------------------------

// 3. Using single for loop

class Solution {
    public int[] replaceElements(int[] arr) {

        int max = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }

        return arr;
    }
}

// TC: O(n), SC: O(1)
