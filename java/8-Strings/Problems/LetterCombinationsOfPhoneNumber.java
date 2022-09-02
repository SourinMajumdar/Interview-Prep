// Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Solution: https://www.youtube.com/watch?v=8orpUBZZ9l0

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Deque<String> q = new ArrayDeque<>();
        q.add("");

        for (int i = 0; i < digits.length(); i++) {
            String d = digits.substring(i, i + 1);
            String fromStr = str[Integer.parseInt(d)];
            int qSize = q.size();

            for (int j = 0; j < qSize; j++) {
                String pull = q.pollFirst();

                for (int k = 0; k < fromStr.length(); k++) {
                    String temp = pull.concat(fromStr.charAt(k) + "");
                    q.add(temp);
                }
            }
        }

        while (!q.isEmpty()) result.add(q.poll());

        return result;
    }
}
/*

TC: O(4 ^ n)

Each digit can be presented at most by 4 letters. On each iteration we go over all 4 of them. And we do this N (the number of digits) time. The complexity would be at most O(4 ^ N)

SC: O(m * n)
m -> length of string under a digit
n -> length of string under the

basically product of the lengths of all thestrings under each keypad digit

Also in worst case there can be 4 digits each representing a 4 letter string,
so similarly WORST SPACE COMPLEXITY turns out to be O(4 ^ n)

*/