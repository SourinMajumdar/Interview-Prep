// Link: https://leetcode.com/problems/generate-parentheses/

class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate("(", 1, 0, n);
        return result;
    }

    public void generate(String current, int open, int closed, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) generate(current + "(", open + 1, closed, n);
        if (closed < open) generate(current + ")", open, closed + 1, n);
    }
}

// TC: O(4 ^ n), SC: O(4 ^ n)
