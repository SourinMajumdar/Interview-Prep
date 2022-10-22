// Link: https://leetcode.com/problems/most-common-word/
// Solution: https://www.youtube.com/watch?v=q2v5nik5vwU


class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String s : banned) set.add(s);

        Map<String, Integer> map = new HashMap<>();
        String[] para = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");

        for (String w : para) {
            if (!set.contains(w)) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (String key : map.keySet()) {
            if (ans.toString().equals("") || map.get(key) > map.get(ans.toString())) {
                ans.setLength(0);
                ans.append(key);
            }
        }

        return ans.toString();

//        String ans = "";
//
//        for (String key : map.keySet()) {
//            if (ans.equals("") || map.get(key) > map.get(ans)) {
//                ans = key;
//            }
//        }
//
//        return ans;
    }
}

// TC: O(n) + O(m * logn) - set.contains() costs O(logn)
// SC: O(n) + O(m)
// n is the length of banned array
// m is the size of paragraph string array