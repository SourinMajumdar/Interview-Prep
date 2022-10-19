// Link: https://leetcode.com/problems/maximum-number-of-pairs-in-array/

class Solution {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);

            if (map.get(i) == 2) {
                pairs++;
                map.remove(i);
            }
        }

        return new int[] {pairs, map.size()};
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int[] numberOfPairs(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(nums);
        int pairs = 0;

        for (int i : nums) {
            if (stack.contains(i)) {
                pairs++;
                stack.pop();
            }
            else stack.push(i);
        }

        return new int[]{pairs, stack.size()};
    }
}

// TC: O(n * logn) + O(n) => O(n * logn)
// SC: O(n)