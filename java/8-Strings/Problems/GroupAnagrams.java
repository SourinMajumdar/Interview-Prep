// Link: https://leetcode.com/problems/group-anagrams
// Solution: https://www.youtube.com/watch?v=ptgykfAEax8

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> grouped = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);

            String sorted = new String(characters);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(str);
        }

        grouped.addAll(map.values());
        return grouped;
    }
}


// TC: O(n * m * logm), SC: O(n)
// n -> number of strings in strs
// m -> max length of a string in strs