// Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> ops = Set.of("+", "-", "*", "/");

        for (String s : tokens) {
            if (ops.contains(s)) {
                int a = stack.pop();
                int b = stack.pop();
                int c = 0;

                switch(s) {
                    case "+" -> {c = b + a;}
                    case "-" -> {c = b - a;}
                    case "*" -> {c = b * a;}
                    case "/" -> {c = b / a;}
                }

                stack.push(c);
            }

            else stack.push(Integer.parseInt(s));
        }

        return stack.peek();
    }
}

// TC: O(n), SC: O(n)