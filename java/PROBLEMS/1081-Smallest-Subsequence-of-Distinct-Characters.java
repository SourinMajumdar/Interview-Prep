// Link: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

// Solution: https://www.youtube.com/watch?v=ht-zr2xlfdk


class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        boolean[] visited = new boolean[26];
        int[] lastIndex = new int[26];

        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            if(visited[c]) continue;
            visited[c] = true;

            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek()] > i) {
                visited[stack.pop()] = false;
            }

            stack.push(c);
        }

        StringBuilder ans = new StringBuilder();

        for (Integer i : stack) {
            ans.append((char)(i + 'a'));
        }

        return ans.toString();
    }
}

// TC: O(n), SC: O(n)