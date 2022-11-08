// Link: https://leetcode.com/problems/to-lower-case/

class Solution {
    public String toLowerCase(String s) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 90 && arr[i] >= 65) {     // or arr[i] <= 'Z' && arr[i] >= 'A'
                arr[i] += 32;
            }
        }

        return new String(arr);
    }
}

// TC: O(n), SC: O(n)