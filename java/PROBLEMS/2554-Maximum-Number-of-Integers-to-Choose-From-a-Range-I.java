// Link: https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/description/

// biweekly 97, 4 Jan 2023
// Q2

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int i : banned) {
            set.add(i);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (i <= maxSum) {
                count++;
                maxSum -= i;
            } else {
                break;
            }
        }

        return count;
    }
}

    // Let kkk be the size of the array banned.

    // Time complexity: O(k + n)
    // Space complexity: O(k)