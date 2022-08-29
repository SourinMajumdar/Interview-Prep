// Link: https://leetcode.com/problems/sort-characters-by-frequency/
// Solution: https://www.youtube.com/watch?v=trFw8IDw2Vg

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        StringBuilder str = new StringBuilder();

        while (!pq.isEmpty()) {
            char current = pq.poll();
            for (int i = 0; i < map.get(current); i++) {
                str.append(current);
            }
        }

        return str.toString();
    }
}

// TC: O(n) + O(n * logn) + O(n) => O(n * logn)
// SC: O(n)