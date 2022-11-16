// Link: https://leetcode.com/problems/baseball-game/

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String s : operations) {
            if (s.equals("+")) {
                int a = stack.pop();
                int newScore = a + stack.peek();
                stack.push(a);
                stack.push(newScore);
            }
            else if (s.equals("D")) {
                stack.push(2 * stack.peek());
            }
            else if (s.equals("C")) {
                stack.pop();
            }
            else stack.push(Integer.parseInt(s));
        }

        int totalScore = 0;
        while (!stack.isEmpty()) totalScore += stack.pop();

        return totalScore;
    }
}


// TC: O(n), SC: O(n)