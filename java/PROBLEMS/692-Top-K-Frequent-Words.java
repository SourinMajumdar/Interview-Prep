// Link: https://leetcode.com/problems/top-k-frequent-words/
// Solution: Learn Overflow
// https://www.youtube.com/watch?v=4dPoGA4WfL4

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ?
                b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        List<String> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(0, pq.poll().getKey());
        }

        return ans;
    }
}


// TC: O(n) + O(k * logk) + O(k * k * logk)
// n is the length of input array
// k is the length of priority queue / output array


// SC: O(m) + O(k)
// m is the size of the map



class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
            (w1, w2) -> map.get(w1) == map.get(w2) ?
             w2.compareTo(w1) : map.get(w1) - map.get(w2)
        );

        for (String s : map.keySet()) {
            pq.offer(s);
            if (pq.size() > k) pq.poll();
        }

        List<String> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(0, pq.poll());
        }

        return ans;
    }
}


// TC: O(n) + O(k * logk) + O(k * k * logk)
// n is the length of input array
// k is the length of priority queue / output array

// SC: O(m) + O(k)
// m is the size of the map