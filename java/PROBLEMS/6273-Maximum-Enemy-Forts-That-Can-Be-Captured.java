// Link: https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/

// biweekly 94, 24 dec 2022
// Q1

class Solution {
    public int captureForts(int[] forts) {
        int ans = 0, max = 0;
        int n = forts.length;

        for (int i = 0; i < n; i++) {
            if (forts[i] == 1) {
                int count = 0;
                for (int j = i + 1; j < n; j++) {
                    if (forts[j] == 0) count++;
                    else if (forts[j] == 1) break;
                    else {
                        max = Math.max(max, count);
                        break;
                    }
                }

                count = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (forts[j] == 0) count++;
                    else if (forts[j] == 1) break;
                    else {
                        max = Math.max(max, count);
                        break;
                    }
                }
            }
        }

        return max;
    }
}

// TC: O(n ^ 2), SC: O(1)