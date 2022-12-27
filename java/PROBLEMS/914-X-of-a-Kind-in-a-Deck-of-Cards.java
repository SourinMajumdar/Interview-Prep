// Link: https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int gcd = 0;
        for (int val : map.values()) {
            gcd = gcd(gcd, val);
        }

        return gcd > 1;
    }

    public int gcd(int a, int b) {
        return (b == 0)? a : gcd(b, a % b);
    }
}

// TC: O(n + k), SC: O(k)
// k -> number of unique elements in deck