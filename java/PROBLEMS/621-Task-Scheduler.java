// Link: https://leetcode.com/problems/task-scheduler/description/
// https://www.youtube.com/watch?v=s8p8ukTyA2I

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int cnt = pq.poll() - 1;

                if (cnt != 0) {
                    q.offer(new Pair(cnt, time + n));
                }
            }

            if (!q.isEmpty() && q.peek().getValue() == time) {
                pq.offer(q.poll().getKey());
            }
        }

        return time;
    }
}

// TC: O(n * log26) => O(n)
// SC: O(26) => O(1)




class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());

        int time = 0;

        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            for (int i : list) {
                if (--i > 0) pq.offer(i);
            }

            time += pq.isEmpty()? list.size(): n + 1;
        }

        return time;
    }
}

// TC: O(n * log26) => O(n)