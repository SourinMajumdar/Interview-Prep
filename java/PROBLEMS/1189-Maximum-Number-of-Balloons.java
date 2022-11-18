// Link: https://leetcode.com/problems/maximum-number-of-balloons/

class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>(){{
            put('b', 1); put('a', 1);
            put('l', 2); put('o', 2);
            put('n', 1);
        }};

        for (char c : text.toCharArray()) {
            if (map2.containsKey(c)) {
                map1.put(c, map1.getOrDefault(c, 0) + 1);
            }
        }

        int count = text.length();

        for (char c : map2.keySet()) {
            count = Math.min(count, map1.getOrDefault(c, 0) / map2.get(c));
        }

        return count;
    }
}

// TC: O(n)

// SC: O(5) => O(1)
// - only the letters of "balloon" will be stored in the maps.
// - size of map would never exceed 5


