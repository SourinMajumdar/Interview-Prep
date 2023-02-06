// Link: https://leetcode.com/problems/house-robber-iv/description/

// weekly 331, 5 Jan 2023
// Q3


class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 1, r = (int) 1e9;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isPossible(nums, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

    private boolean isPossible(int[] nums, int maxMoney, int k) {
        int houseStolen = 0, lastStolenIdx = -2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxMoney) {
                continue;
            }
            if (i == lastStolenIdx + 1) {
                continue;
            }

            houseStolen++;
            lastStolenIdx = i;
        }

        return houseStolen >= k;
    }
}

// OR

class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 1, r = (int) 1e9;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int houseStolen = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    houseStolen++;
                    i++;
                }
            }
            if (houseStolen >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }
}

/*
    Let n be the size of our search space (1 -> 10^9) and m be the number of houses.

    We are performing a binary search on the search space which would cost O(logn) runtime
    and a thorough looping over the houses which would cost O(m) runtime.

    Time complexity: O(m * logn)
    Space complexity: O(1)

 */