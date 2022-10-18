// Link: https://leetcode.com/problems/count-and-say/
// Solution: https://www.youtube.com/watch?v=VE8yEc4R6q0

class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for (int i = 1; i < n; i++) {
            s = helper(s);
        }

        return s;
    }

    public String helper(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == prev) count++;
            else {
                sb.append(count);
                sb.append(prev);
                prev = c;
                count = 1;
            }
        }

        sb.append(count);
        sb.append(prev);

        return sb.toString();
    }
}


// TC: O(n * k) - k is the variable size of string
// SC: O(1)