// Link: https://leetcode.com/problems/find-players-with-zero-or-one-losses/


class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winners = new HashSet<>();
        Map<Integer, Integer> losers = new HashMap<>();

        for (int[] m : matches) {
            losers.put(m[1], losers.getOrDefault(m[1], 0) + 1);
        }

        for (int[] m : matches) {
            if (!losers.containsKey(m[0])) {
                winners.add(m[0]);
            }
        }

        List<Integer> w = new ArrayList<>(winners);
        List<Integer> l = new ArrayList<>();

        for (int n : losers.keySet()) {
            if (losers.get(n) == 1) l.add(n);
        }

        Collections.sort(w); Collections.sort(l);

        return new ArrayList<>(Arrays.asList(w, l));
    }
}

// TC: O(3*n + 2*n*logn) => O(n * logn)
// SC: O(4 * n) => O(n)

