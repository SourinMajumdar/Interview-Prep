// Link: https://leetcode.com/problems/minimum-operations-to-make-array-equal-ii/description/

// biweekly 96, 22 Jan 2023
// Q2


class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        // if both arrays are equal already,
        // we don't need to perform any operation
        if (Arrays.equals(nums1, nums2)) {
            return 0;
        }
        // if k is 0, arrays should be equal already
        if (k == 0) {
            return Arrays.equals(nums1, nums2)? 0 : -1;
        }

        // posOps -> Positive operations, negOps -> Negative operations
        // They will store how many positive operations (+k) and
        // how many negative operations (-k) we will perform respectively
        long posOps = 0, negOps = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = nums1[i] - nums2[i];     // get the difference
            // the difference should be divisible by k, very basic stuff
            if (diff % k != 0) {    // if not
                return -1;    // its not possible to make thearrays equal
            }
            if (diff < 0) {  // means nums1[i] < nums2[i]
                // we will have to perform a +k operation
                posOps += -diff / k;  // add the number of operations
            } else {         // means nums1[i] > nums2[i]
                // we will have to perform a -k operation
                negOps += diff / k;   // add the number of operations
            }
        }

        // now when we perform a positive operation, we perform a negative operation at the same time
        // so number of +ve operations should be equal to number of -ve operations
        // if yes, we would return either posOp or negOp
        // because we are ot performing negOp + posOp operations
        // 1 -ve operation and 1 +ve operation is one whole operation
        // because we are performing them simultaneously
        // if not equal we will return -1
        return (posOps == negOps)? posOps : -1;
    }
}


// TC: O(n), SC: O(1)