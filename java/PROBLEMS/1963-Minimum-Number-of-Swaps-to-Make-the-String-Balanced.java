// Link: https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/

// https://www.youtube.com/watch?v=3YDBT9ZrfaU


class Solution {
    public int minSwaps(String s) {
        int closed = 0, maxClosed = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') closed--;
            else closed++;
            maxClosed = Math.max(closed, maxClosed);
        }

        return (maxClosed + 1) / 2;
    }
}

// TC: (n), SC: O(1)


class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '[') st.push(c);
            else {
                if(!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                }
                else st.push(c);
            }
        }

        return (st.size() / 2 + 1) / 2;
    }
}

// TC: O(n), SC: O(n)