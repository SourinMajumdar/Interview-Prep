// Link: https://leetcode.com/problems/count-increasing-quadruplets/description/
// https://www.youtube.com/watch?v=RxsbwiXvNkQ

// weekly 330, 29 Jan 2023
// Q4


class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int[][] greaterThan = new int[n][n];
        int[][] lesserThan = new int[n][n];
        // greaterThan[i][j] means count of numbers between index i & j larger than nums[i]
        // lesserThan[i][j] means count of numbers between index i & j smaller than nums[j]
        // i & j are both inclusive

        // MOTTO: nums[i] < nums[k] < nums[j] < nums[l]

        // Iterate to look for 'nums[j] > nums[i]' possibilities
        for (int i = 0; i < n; i++) {
            int count = 0;  // for the current window (i -> j)
            for (int j = i + 1; j < n; j++) {
                // increment count if nums[j] > nums[i]
                count += (nums[j] > nums[i])? 1 : 0;
                greaterThan[i][j] = count;  // record the count
            }
        }

        // Iterate to look for 'nums[l] > nums[k]' possibilities
        for (int l = n - 1; l >= 0; l--) {
            int count = 0;  // for the current window (k -> l)
            for (int k = l - 1; k >= 0; k--) {
                // increment count if nums[l] > nums[k]
                count += (nums[k] < nums[l])? 1 : 0;
                lesserThan[k][l] = count;   // record the count
            }
        }

        long ans = 0;
        // Iterate to look for 'nums[j] > nums[k]' possibilities
        for (int j = 1; j < n - 2; j++) {
            for (int k = j + 1; k < n - 1; k++) {
                if (nums[j] < nums[k]) {    // if the opposite
                    continue;               // then simply ignore and skip
                }

                // We have found now reached at a position where nums[j] > nums[k]
                // We need the number of elements which are smaller than nums[j]

                // 1  2  3  5  6  4  5  7  8  9
                //             j  k
                // |--------------| --> count of (0 -> k)
                //             |--| --> count of (j -> k)
                // |-----------|    --> count of (0 -> j) => which we want!!!

                // So number of elements less than nums[j] in the range i -> j is
                // count of (0 -> k) - count of (j -> k)
                int possibleI = lesserThan[0][k] - lesserThan[j][k];

                // Now we need the number of elements which are greater than nums[k]

                // 1  2  3  5  6  4  5  7  8  9
                //             j  k
                //             |--------------|   --> count of (j -> n-1)
                //             |--|               --> count of (j -> k)
                //                |-----------|   --> count of (k -> n-1) => which we want!!!

                // So number of elements greater than nums[k] in the range k -> n-1 is
                // count of (j -> n-1) - count of (j -> k)
                int possibleL = greaterThan[j][n-1] - greaterThan[j][k];

                // multiply both of them to get the number of possible permutation of indices
                ans += (possibleI * possibleL);     // and add to ans variable
            }
        }

        return ans;     // return the final answer
    }
}





class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int[][] greaterThan = new int[n][n];
        int[][] lesserThan = new int[n][n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                count += (nums[j] > nums[i])? 1 : 0;
                greaterThan[i][j] = count;
            }
        }

        for (int l = n - 1; l >= 0; l--) {
            int count = 0;
            for (int k = l - 1; k >= 0; k--) {
                count += (nums[k] < nums[l])? 1 : 0;
                lesserThan[k][l] = count;
            }
        }

        long ans = 0;
        for (int j = 1; j < n - 2; j++) {
            for (int k = j + 1; k < n - 1; k++) {
                if (nums[j] < nums[k]) {
                    continue;
                }

                int possibleI = lesserThan[0][k] - lesserThan[j][k];
                int possibleL = greaterThan[j][n-1] - greaterThan[j][k];
                ans += (possibleI * possibleL);
            }
        }

        return ans;
    }
}



// TC: O(3 * n^2) => O(n^2)
// SC: O(2 * n^2) => O(n^2)