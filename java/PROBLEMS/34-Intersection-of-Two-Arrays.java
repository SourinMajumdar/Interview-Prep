// Link: https://leetcode.com/problems/intersection-of-two-arrays/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> intersection = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                intersection.add(i);
            }
        }

        int[] ans = new int[intersection.size()];
        int idx = 0;

        for (int i : intersection) {
            ans[idx++] = i;
        }

        return ans;

        // return intersection.stream().mapToInt(i -> i).toArray();
    }
}

// TC: O(n + m) + O(k)
// SC: O(m + n) + O(k)