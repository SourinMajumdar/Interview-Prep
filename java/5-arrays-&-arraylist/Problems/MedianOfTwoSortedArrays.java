// Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/
// Solution:


// Prerequisite: Merge two sorted arrays
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;
        int p1 = 0, p2 = 0, i = 0;
        int[] ans = new int[m + n];

        // When both arrays are non-empty
        if ( m != 0 && n != 0 ) {

            while(p1 < m && p2 < n) {

                if (nums1[p1] > nums2[p2]) {
                    ans[i++] = nums2[p2++];

                } else {
                    ans[i++] = nums1[p1++];
                }

            }

            // After this, one of p1 and p2 will reach their last index
            // So to fill the remaining array
            // (Only one of the following while loops will run)

            while (p1 < m) ans[i++] = nums1[p1++];
            while (p2 < n) ans[i++] = nums2[p2++];

        }

        // If nums2 is empty
        else if (m == 0) {
            for (int ele : nums2) {
                ans[i++] = ele;
            }
        }

        // If nums1 is empty
        else {
            for (int ele : nums1) {
                ans[i++] = ele;
            }
        }


        int mid = (ans.length - 1) / 2;

        if (ans.length % 2 == 1) return ans[mid];
        return (double)(ans[mid] + ans[mid + 1]) / 2;

    }
}

// TC: O(m + n), SC: O(m + n)



