// Link: https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/

// Weekly 311, 18 September 2022
// Q2

class Solution {
    public int longestContinuousSubstring(String s) {
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - 'a';
        }

        int count = 1, maxCount = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] == arr[i]) continue;
            else if (arr[i + 1] != arr[i] + 1) count = 1;
            else count++;
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}

// TC: O(n) + O(n) => O(n)
// SC: O(n)


class Solution {
    public int longestContinuousSubstring(String s) {
        if (s.length() == 1) return 1;

        int currLen = 1, maxLen = 1;

        for(int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) - s.charAt(i) == 1) {
                currLen++;
            } else currLen = 1;

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}

// TC: O(n), SC: O(1)
