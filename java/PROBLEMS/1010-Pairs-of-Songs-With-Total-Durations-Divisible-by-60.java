// Link: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/


class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int mod = t % 60;
            int rem = (mod == 0)? 0 : 60 - mod;
            ans += map.getOrDefault(rem, 0);
            map.put(mod, 1 + map.getOrDefault(mod, 0));
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] freq = new int[61];
        int ans = 0;
        for (int t : time) {
            int mod = t % 60;
            int rem = (mod == 0)? 0 : 60 - mod;
            ans += freq[rem];
            freq[mod]++;
        }

        return ans;
    }
}

// TC: O(n), SC: O(1)