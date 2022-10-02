// Link: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
// Solution: https://www.youtube.com/watch?v=BeyJboRnKDI

class Solution {
    Map<String, Integer> map = new HashMap<>();

    public int numRollsToTarget(int dice, int faces, int target) {
        if (target < dice || target > dice * faces) return 0;
        if (dice == 1) return (target <= faces) ? 1 : 0;

        String combination = "" + dice + faces + target;
        int sum = 0;

        if (!map.containsKey(combination)) {
            for (int i = 1; i <= faces; i++) {
                sum += numRollsToTarget(dice - 1, faces, target - i);
                sum %= 1000000007;
            }

            map.put(combination, sum);
        }

        return map.get(combination);
    }
}

