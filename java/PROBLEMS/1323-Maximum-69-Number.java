// Link: https://leetcode.com/problems/maximum-69-number/

class Solution {
    public int maximum69Number(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '6') {
                arr[i] = '9';
                break;
            }
        }

        return Integer.valueOf(new String(arr));
    }
}

// TC: O(n), SC: O(n)
// n is the number of digits



class Solution {
    public int maximum69Number (int num) {
        return Integer.valueOf(String.valueOf(num).replaceFirst("6", "9"));
    }
}

// TC: O(n), SC: O(1)