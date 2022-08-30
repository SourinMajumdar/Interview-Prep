// Link: https://leetcode.com/problems/smallest-value-of-the-rearranged-number/
// Solution: https://www.youtube.com/watch?v=L_NvlKDpN1M

class Solution {
    public long smallestNumber(long num) {

        boolean isNegative = num < 0;

        num = Math.abs(num);

        char[] arr = ("" + num).toCharArray();

        if (arr.length == 1) return Long.parseLong(String.valueOf(arr));

        long ans = 0;
        Arrays.sort(arr);

        if (isNegative) {
            String ansStr = "";

            for (int i = arr.length - 1; i >= 0; i--) {
                ansStr += arr[i];
            }

            ans = - Long.parseLong(ansStr);

        } else {

            if (arr[0] == '0'){
                int i = 0;
                while (arr[i] == '0') i++;

                if (i < arr.length) {
                    arr[0] = arr[i];
                    arr[i] = '0';
                }
            }

            ans = Long.parseLong(String.valueOf(arr));
        }

        return ans;
    }
}

// TC: O(n * logn), SC: O(n)