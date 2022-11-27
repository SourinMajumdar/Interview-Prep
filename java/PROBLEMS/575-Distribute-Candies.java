// Link: https://leetcode.com/problems/distribute-candies

class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> set = new HashSet<>();

        for (int c : candyType) set.add(c);

        return Math.min(set.size(), n / 2);
    }
}

// TC: O(n), SC: O(n)