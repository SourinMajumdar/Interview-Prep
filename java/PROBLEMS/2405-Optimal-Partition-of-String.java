// Link: https://leetcode.com/problems/optimal-partition-of-string/
// Solution: https://www.youtube.com/watch?v=qSgcLMbHY0M

// Using boolean array (faster)
class Solution {
    public int partitionString(String s) {
        int count = 1;
        boolean[] arr = new boolean[26];

        for (char c : s.toCharArray()) {
            if (arr[c - 'a']) {
                count++;
                arr = new boolean[26];
            }

            arr[c - 'a'] = true;

        }

        return count;
    }
}

// TC: O(n), SC: O(1)


// Using hashset
class Solution {
    public int partitionString(String s) {
        int count = 1;
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                count++;
                set = new HashSet();
                // set.clear();
            }

            set.add(c);

        }

        return count;
    }
}

// TC: O(n), SC: O(n)