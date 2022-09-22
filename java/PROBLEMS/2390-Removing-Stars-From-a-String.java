// Link: https://leetcode.com/problems/removing-stars-from-a-string/

// Weekly 308, Aug 28, 2022
// Q2


// Stack
class Solution {
    public String removeStars(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') stack.pop();
            else stack.push(c);
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}

// TC: O(n), SC: O(n)


// No Stack
class Solution {
    public String removeStars(String s) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') str.deleteCharAt(str.length() - 1);
            else str.append(c);
        }

        return str.toString();
    }
}

// TC: O(n), SC: O(1)


// Two Pointers
class Solution {
    public String removeStars(String s) {
        char[] ch = new char[s.length()];
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '*') j--;
            else ch[j++] = c;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < j; i++) ans.append(ch[i]);
        return ans.toString();
    }
}

// TC: O(n); SC: O(n)