// Link: https://leetcode.com/problems/find-the-difference-of-two-arrays/
// Solution:


class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();     // set to store all nums1 elements
        Set<Integer> num2Set = new HashSet<>();     // set to store all nums2 elements

        for (int n : nums1) num1Set.add(n);
        for (int n : nums2) num2Set.add(n);

        Set<Integer> set1 = new HashSet<>();        // set to store elements that are unique to nums2

        for (int n : nums1) {
            if (!num2Set.contains(n)) {
                set1.add(n);
            }
        }

        Set<Integer> set2 = new HashSet<>();        // set to store elements that are unique to nums1

        for (int n : nums2) {
            if (!num1Set.contains(n)) {
                set2.add(n);
            }
        }

        List<Integer> list1 = new ArrayList<>();    // list to store set1 values
        List<Integer> list2 = new ArrayList<>();    // list to store set2 values

        list1.addAll(set1); list2.addAll(set2);

        return Arrays.asList(list1, list2);
    }
}

// TC: 2 * O(n + m) => O(n + m)
// SC: 3 * O(n + m) => O(n + m)