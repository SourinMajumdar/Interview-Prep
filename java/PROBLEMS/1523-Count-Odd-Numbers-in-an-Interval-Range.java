// Link: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/

class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if ((i & 1) == 1) {
                count++;
            }
        }

        return count;
    }
}

// TC: O(high - low), SC: O(1)


class Solution {
    public int countOdds(int low, int high) {
        int lower = (int) Math.ceil((low - 1) * 1.0 / 2);
        int higher = (int) Math.ceil(high * 1.0 / 2);
        return higher - lower;
    }
}

class Solution {
    public int countOdds(int low, int high) {
        return (int) (Math.ceil(high * 1.0 / 2) - Math.ceil((low - 1) * 1.0 / 2));
    }
}

// TC = SC = O(1)