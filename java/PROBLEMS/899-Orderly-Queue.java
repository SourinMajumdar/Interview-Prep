// Link: https://leetcode.com/problems/orderly-queue/
// https://www.youtube.com/watch?v=-ryxBLATIUQ

class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;

            for (int i = 0; i < s.length(); i++) {
                String reordered = s.substring(i) + s.substring(0, i);

                if (ans.compareTo(reordered) > 0) {
                    ans = reordered;
                }
            }

            return ans;
        }

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}

// TC: O(n ^ 2), SC: O(n)