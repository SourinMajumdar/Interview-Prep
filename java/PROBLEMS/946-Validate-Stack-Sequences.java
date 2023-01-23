// Link: https://leetcode.com/problems/validate-stack-sequences/description/
// https://www.youtube.com/watch?v=vHKXT0cSI54


class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int n : pushed) {
            stack.push(n);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return i == popped.length;  // or stack.isEmpty()
    }
}

// TC: O(n), SC: O(n)

