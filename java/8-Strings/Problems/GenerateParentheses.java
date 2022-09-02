// Link: https://leetcode.com/problems/generate-parentheses/
// Solution: https://www.youtube.com/watch?v=R6RddNeX3ug

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("(", 1, 0, result, n);
        return result;
    }

    public void generate(String current, int open, int closed, List<String> result, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) generate(current + "(", open + 1, closed, result, n);
        if (closed < open) generate(current + ")", open, closed + 1, result, n);
    }
}

// TC: O(4 ^ n), SC: O(4 ^ n)