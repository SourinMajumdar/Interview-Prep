// Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/
// Solution: https://www.youtube.com/watch?v=NTop3VTjmxk


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

// Using binary search
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int lo = 0, hi = m;

        while (lo <= hi) {
            int cut1 = (lo + hi) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            // Partition found
            if ( l1 <= r2 && l2 <= r1 ) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }

                return Math.max(l1, l2);
            }

            else if (l1 > r2) hi = cut1 - 1;
            else lo = cut1 + 1;

        }

        return -1;
    }
}

// TC: O(log(m + n)), SC: O(1)



