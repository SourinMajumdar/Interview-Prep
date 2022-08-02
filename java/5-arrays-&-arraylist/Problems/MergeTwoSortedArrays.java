// Problem: https://leetcode.com/problems/merge-sorted-array/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }
}

// TC: O(m + n), SC: O(1)

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
    src – the source array.
    srcPos – starting position in the source array.
    dest – the destination array.
    destPos – starting position in the destination data.
    length – the number of array elements to be copied.
*/



// Using two pointers (https://www.youtube.com/watch?v=FyzWXlSMNoI)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1, ptr2 = n - 1, i = m + n -1;

        while( ptr1 >=0 && ptr2 >= 0 && i >= 0 ) {

            if(nums1[ptr1] < nums2[ptr2]) {
                nums1[i--] = nums2[ptr2--];

            } else { // nums1[ptr1] > nums2[ptr2] or (nums1[ptr1] == nums2[ptr2]) {
                nums1[i--] = nums1[ptr1--];
            }
        }

        while ( ptr1 >= 0 ) {
            nums1[ptr1--] = nums1[i--];
        }

        while (ptr2 >= 0) {
            nums1[ptr2--] = nums2[i--];
        }
    }
}

// TC: O(m + n), SC: O(1)

