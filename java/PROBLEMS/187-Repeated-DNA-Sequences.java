// Link: https://leetcode.com/problems/repeated-dna-sequences/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() <= 10) return ans;

        Map<String, Integer> map = new HashMap<>();

        int i = 0, j = 10;

        while (j <= s.length()) {
            String subStr = s.substring(i++, j++);
            map.put(subStr, map.getOrDefault(subStr, 0) + 1);

            if (map.get(subStr) > 1 && !ans.contains(subStr)) {
                ans.add(subStr);
            }
        }

        return ans;
    }
}


// TC: O(n * 10) => O(n)
// SC: O(n)