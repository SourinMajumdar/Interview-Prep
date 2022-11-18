// Link: https://leetcode.com/problems/can-place-flowers/


class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int planted = 0;
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                boolean prev = i == 0 || flowerbed[i - 1] == 0;
                boolean next = i == len - 1 || flowerbed[i + 1] == 0;

                if (prev && next) {
                    flowerbed[i] = 1;
                    planted++;
                }
            }
        }

        return planted >= n;
    }
}

// TC: O(N), SC: O(1)