// Link: https://leetcode.com/problems/sender-with-largest-word-count/description/

class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            int words = messages[i].split(" ").length;
            String name = senders[i];
            map.put(name, words + map.getOrDefault(name, 0));
        }

        String ans = "";
        int max = 0;
        for (String name : map.keySet()) {
            int words = map.get(name);
            if (words > max) {
                max = words;
                ans = name;
            } else if (words == max) {
                int x = ans.compareTo(name);
                ans = (x > 0)? ans : name;
            }
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)