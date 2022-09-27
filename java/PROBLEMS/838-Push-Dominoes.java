// Link: https://leetcode.com/problems/push-dominoes/


// Solution: https://www.youtube.com/watch?v=Fo4ORqOLDCY

class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = new char[n + 2];
        arr[0] = 'L'; arr[n + 1] = 'R';

        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = dominoes.charAt(i - 1);
        }

        int i = 0, j = 1;

        while (j < arr.length) {
            while (arr[j] == '.') j++;
            if (j - i > 1) helper(arr, i, j);
            i = j++;
        }

        StringBuilder ans = new StringBuilder();
        for (int idx = 1; idx < arr.length - 1; idx++) {
            ans.append(arr[idx]);
        }

        return ans.toString();
    }

    public void helper(char[] arr, int i, int j) {
        // case 1
        if (arr[i] == 'L' && arr[j] == 'L') {
            for (int a = i + 1; a < j; a++) {
                arr[a] = 'L';
            }
        }

        // case 2
        else if (arr[i] == 'R' && arr[j] == 'R') {
            for (int a = i + 1; a < j; a++) {
                arr[a] = 'R';
            }
        }

        // case 3
        else if (arr[i] == 'L' && arr[j] == 'R') {
            // do nothing
        }

        // case 4
        // arr[i] == 'R' && arr[j] == 'L'
        else {
            int l = i + 1, r = j - 1;
            while (l < r) {
                arr[l++] = 'R';
                arr[r--] = 'L';
            }
        }
    }
}

// TC: O(n) + O(n * n) + O(n);
// SC: O(n)



// Solution:

