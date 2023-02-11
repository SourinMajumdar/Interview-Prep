// Link: https://leetcode.com/problems/naming-a-company/

class Solution {
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> map = new HashMap<>();
        for (String s : ideas) {
            map.putIfAbsent(s.charAt(0), new HashSet<>());
            map.get(s.charAt(0)).add(s.substring(1, s.length()));
        }

        long ans = 0;
        for (char c1 : map.keySet()) {
            for (char c2 : map.keySet()) {
                if (c1 == c2) {
                    continue;
                }

                int common = 0;
                for (String suffix : map.get(c1)) {
                    if (map.get(c2).contains(suffix)) {
                        common++;
                    }
                }

                int distinct1 = map.get(c1).size() - common;
                int distinct2 = map.get(c2).size() - common;
                ans += distinct1 * distinct2;
            }
        }

        return ans;
    }
}

// TC: O(n + 26^2 * n), SC: O(26 * n)