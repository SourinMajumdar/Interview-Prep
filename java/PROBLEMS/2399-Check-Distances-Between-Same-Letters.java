// Link: https://leetcode.com/problems/check-distances-between-same-letters/

// Weekly 309, 4th September
// Q1

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            int inBetween = i - arr[index] - 1;
            if (arr[index] > -1 && inBetween != distance[index]) return false;
            arr[index] = i;
        }

        return true;
    }
}

// TC: O(n), SC: O(1)


class Solution {
    public boolean checkDistances(String s, int[] distance) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int firstIdx =  s.indexOf(c);
            int lastIdx = s.lastIndexOf(c);
            int inBetween = lastIdx - firstIdx - 1;
            if (inBetween != distance[c - 'a']) return false;
        }

        return true;
    }
}

// TC: O(n), SC: O(1)