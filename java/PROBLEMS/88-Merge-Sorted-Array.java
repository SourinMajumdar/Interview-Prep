// Problem: https://leetcode.com/problems/merge-sorted-array/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }
}

// TC: O(m + n) + O((m+n) * log(m+n)) => O((m+n) * log(m+n))
// SC: O(1)

// OR

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}

/*
public static void arraycopy(
    @NotNull  Object src,
    int srcPos,
    @NotNull  Object dest,
    int destPos,
    int length
)

Params:
    src     – the source array.
    srcPos  – starting position in the source array.
    dest    – the destination array.
    destPos – starting position in the destination data.
    length  – the number of array elements to be copied.
*/



// Using two pointers (https://www.youtube.com/watch?v=FyzWXlSMNoI)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;

        // We start from the end of both arrays
        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            }
            else {
                nums1[k--] = nums2[j--];
            }
        }

        // Either of i or j would remain greater than 0, so to fill the remaining array we run another loop
        // Either of the two loops will be executed
        while (i >= 0) nums1[k--] = nums1[i--];     // if j had reached 0 first
        while (j >= 0) nums1[k--] = nums2[j--];     // if i had reached 0 first
    }
}

// TC: O(m + n), SC: O(1)

