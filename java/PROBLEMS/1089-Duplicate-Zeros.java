// Link: https://leetcode.com/problems/duplicate-zeros/

class Solution {
    public void duplicateZeros(int[] arr) {
        List<Integer> l = new ArrayList<>();

        for (int n : arr) {
            l.add(n);
            if (n == 0) l.add(0);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = l.get(i);
        }
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 2; j >= i; j--) {
                    arr[j + 1] = arr[j];
                }

                i++;
            }
        }
    }
}

// TC: O(n ^ 2), SC: O(1)