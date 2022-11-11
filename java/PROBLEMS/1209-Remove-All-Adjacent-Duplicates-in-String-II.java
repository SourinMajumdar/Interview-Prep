// Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().character != c) {
                stack.push(new Pair(c, 1));
            }

            else if (stack.peek().character == c) {
                if (stack.peek().count < k - 1) {
                    stack.peek().count++;
                }
                else if (stack.peek().count == k - 1) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Pair p : stack) {
            while (p.count-- > 0) {
                sb.append(p.character);
            }
        }

        return sb.toString();
    }

    class Pair {
        char character;
        int count;

        public Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
}


// TC: O(n), SC: O(n)