// Link: https://leetcode.com/problems/optimal-partition-of-string/
// Solution: https://www.youtube.com/watch?v=qSgcLMbHY0M

class Solution {
    public int partitionString(String s) {
        int count = 1;
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {

            if (set.contains(c)) {
                count++;
                set = new HashSet<>();
                set.add(c);

            } else {
                set.add(c);
            }
        }

        return count;
    }
}

// TC: O(n), SC: O(n)