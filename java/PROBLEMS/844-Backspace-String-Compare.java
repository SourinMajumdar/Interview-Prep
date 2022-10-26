// Link: https://leetcode.com/problems/backspace-string-compare/

// Stack

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return backspaced(s).equals(backspaced(t));
    }

    public String backspaced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            }
            else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        return stack.toString();
    }
}

// O(m + n), SC: O(m + n)



// Stringbuilder

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return backspaced(s).equals(backspaced(t));
    }

    public String backspaced(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            }
            else if (sb.length() != 0) {
                sb.setLength(sb.length() - 1);
            }
        }

        return sb.toString();
    }
}

// O(m + n), SC: O(m + n)


// Two Pointers

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return backspaced(s).equals(backspaced(t));
    }

    public String backspaced(String s) {
        char[] ch = new char[s.length()];
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '#') {
                ch[j++] = c;
            }
            else if (j > 0) j--;
        }

        return String.valueOf(ch).substring(0, j);
    }
}

// TC: O(m + n), SC: O(m + n)