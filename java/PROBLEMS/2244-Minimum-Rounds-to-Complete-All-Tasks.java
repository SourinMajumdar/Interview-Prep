// Link: https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/


/*
For case 3x:        ans += f/3
For case 3x + 1 :   ans += f/3 + 1
For case 3x + 2:    ans += f/3 + 1
 */

class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tasks) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int round = 0;
        for (int count : map.values()) {
            if (count == 1) {
                return -1;
            }
            round += count / 3;
            if (count % 3 != 0) {
                round++;
            }
        }

        return round;
    }
}

// TC: O(n + m), SC: O(m)
// m -> Number of unique difficulties