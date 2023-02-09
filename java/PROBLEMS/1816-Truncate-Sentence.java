// Link: https://leetcode.com/problems/truncate-sentence/description/

class Solution {
    public String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(arr[i]).append(" ");
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}

// TC: O(k), SC: O(n)