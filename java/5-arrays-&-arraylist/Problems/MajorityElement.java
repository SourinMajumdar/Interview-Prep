// Link: https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) > nums.length / 2) {
                max = i;
            }
        }

        return max;
    }
}


// TC: O(n), SC: O(n)


// Using Moore's voting algorithm

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;

        for (int n : nums) {
            if (count == 0) candidate = n;
            if (candidate == n) count++;
            else count--;
        }

        return candidate;
    }
}

// TC: O(n), SC: O(1)
