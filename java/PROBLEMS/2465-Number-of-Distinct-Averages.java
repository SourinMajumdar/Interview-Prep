// Link: https://leetcode.com/contest/biweekly-contest-91/problems/number-of-distinct-averages/


class Solution {
    public int distinctAverages(int[] nums) {
        Set<Double> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums) list.add(i);

        while (!list.isEmpty()) {
            int max = Collections.max(list);
            int min = Collections.min(list);

            double avg = (max + min) / 2.0;
            set.add(avg);

            list.remove(Integer.valueOf(max));
            list.remove(Integer.valueOf(min));
        }

        return set.size();
    }
}

// TC: O(n ^ 2), SC: O(n)