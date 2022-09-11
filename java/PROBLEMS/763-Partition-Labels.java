// Link: https://leetcode.com/problems/partition-labels/
// Solution: https://www.youtube.com/watch?v=X1X_6dJSmq4

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int endIndex = s.lastIndexOf(c);

            for (int j = i + 1; j <= endIndex; j++) {
                endIndex = Math.max(endIndex, s.lastIndexOf(s.charAt(j)));
            }

            ans.add(endIndex - i + 1);
            i = endIndex + 1;
        }

        return ans;
    }
}

// Or using an array to store last indices
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();

        int[] endIndices = new int[26];
        for (int i = 0; i < s.length(); i++) {
            endIndices[s.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int endIndex = endIndices[c - 'a'];

            for (int j = i + 1; j <= endIndex; j++) {
                endIndex = Math.max(endIndex, endIndices[s.charAt(j) - 'a']);
            }

            ans.add(endIndex - i + 1);
            i = endIndex + 1;
        }

        return ans;
    }
}

// TC: O(n)
// SC: O(1) - Ignoring the list which is returned