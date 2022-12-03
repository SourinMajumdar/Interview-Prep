// Link: https://leetcode.com/problems/print-words-vertically/
// https://www.youtube.com/watch?v=mJYnmKJ_y44


class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        List<String> ans = new ArrayList<>();
        int maxLen = getMaxLen(words);

        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                if (i >= word.length()) sb.append(' ');
                else sb.append(word.charAt(i));
            }

            ans.add(trimRight(sb.toString()));
            // ans.add(sb.toString().stripTrailing());
            // ans.add(sb.toString().replaceAll("\\s+$", ""));      --> greater runtime
        }

        return ans;
    }

    private int getMaxLen(String[] arr) {
        int max = 0;
        for (String s : arr) {
            max = Math.max(max, s.length());
        }

        return max;
    }

    private String trimRight(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        return s.substring(0, i + 1);
    }
}

// TC: O(m * n)
// m -> maximum length of word in s
// n -> number of words

// SC: O(n)