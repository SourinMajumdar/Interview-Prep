// Link: https://leetcode.com/problems/reverse-string/


// two ptrs
class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while(i < j){
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}

// TC: O(n), SC: O(1)


// recursion
class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        solve(s, i, j);
    }

    public void solve(char[] s, int left, int right) {
        if (left >= right) return;

        char temp = s[right];
        s[right] = s[left];
        s[left] = temp;

        solve(s, left + 1, right - 1);
    }
}

// TC: O(n), SC: O(n)


// stack

class Solution {
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s) stack.push(c);

        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }
}

// TC: O(n), SC: O(n)
