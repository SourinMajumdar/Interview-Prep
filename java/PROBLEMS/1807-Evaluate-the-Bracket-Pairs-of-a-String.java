// Link: https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(') {
                sb.append(s.charAt(i));
            }
            else if (s.charAt(i) == '(') {
                int start = i + 1;
                while (i < s.length() && s.charAt(i) != ')') {
                    i++;
                }
                sb.append(map.getOrDefault(s.substring(start, i), "?"));
            }
        }

        return sb.toString();
    }
}

// TC: O(n ^ 2), SC: (k)
// n -> length of string
// k -> length of map