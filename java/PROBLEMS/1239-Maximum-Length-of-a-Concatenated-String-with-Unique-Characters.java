// Link: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
// Solution: https://www.youtube.com/watch?v=gfZPl-BWZuo


class Solution {
    public int maxLength(List<String> arr) {
        List<String> ans = new ArrayList<>();
        ans.add("");

        int max = 0;

        for (String s : arr) {
            if (!checkIfUnique(s)) continue;
            List<String> newStrs = new ArrayList<>();

            for (String str : ans) {
                String temp = str + s;
                if (checkIfUnique(temp)) {
                    newStrs.add(temp);
                    max = Math.max(max, temp.length());
                }
            }
            ans.addAll(newStrs);
        }

        return max;
    }

    public boolean checkIfUnique(String s) {
        if (s.length() > 26) return false;
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > 1) return false;
        }

        return true;
    }
}

// TC: O(n^2 * k), SC: O(n)
// n -> size of given input list
// k -> size of individula strings in given list



// https://www.youtube.com/watch?v=pD3cHFNyW2I


class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        maxUnique(arr, 0, "");
        return max;
    }

    public void maxUnique(List<String> arr, int index, String curr) {
        if (index == arr.size() && uniqueCharCount(curr) > max) {
            max = curr.length();
            return;
        }

        if (index == arr.size()) return;

        maxUnique(arr, index + 1, curr);
        maxUnique(arr, index + 1, curr + arr.get(index));
    }

    public int uniqueCharCount(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            if (freq[c - 'a']++ > 0) {
                return 0;
            }
        }

        return s.length();
    }
}

// TC: O(2^n), SC: O(n)