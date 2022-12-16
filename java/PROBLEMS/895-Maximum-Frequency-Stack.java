// Link: https://leetcode.com/problems/maximum-frequency-stack/description/
// https://www.youtube.com/watch?v=Jv5_J1fSju0


class FreqStack {
    Map<Integer, Integer> map;
    List<Stack<Integer>> stkList;

    public FreqStack() {
        map = new HashMap<>();
        stkList = new ArrayList<>();
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        int freq = map.get(val);

        if (freq - 1 >= stkList.size()) {
            stkList.add(new Stack<Integer>());
        }
        stkList.get(freq - 1).push(val);
    }

    public int pop() {
        int size = stkList.size();
        int x = stkList.get(size - 1).pop();

        if (stkList.get(size - 1).isEmpty()) {
            stkList.remove(size - 1);
        }

        map.put(x, map.get(x) - 1);
        if (map.get(x) == 0) {
            map.remove(x);
        }

        return x;
    }
}

// TC: O(1), SC: O(n)