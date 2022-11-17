// Link: https://leetcode.com/problems/asteroid-collision/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            if (ast > 0) {
                stack.push(ast);
            }
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(ast)) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0)  {
                    stack.push(ast);
                }

                if (stack.peek() == Math.abs(ast)) {
                    stack.pop();
                }
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}

// TC: O(n), SC: O(n)