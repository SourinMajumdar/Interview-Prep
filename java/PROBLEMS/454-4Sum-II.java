// Link: https://leetcode.com/problems/4sum-ii/
// Solution: https://www.youtube.com/watch?v=Gp1Kw_gvBx0


// Brute force (TLE)

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;

        for (int i : nums1)
            for (int j : nums2)
                for (int k : nums3)
                    for (int l : nums4)
                        if (i + j + k + l == 0) count++;

        return count;
    }
}

// TC: O(n ^ 4)


class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int l : nums4) {
            map.put(l, map.getOrDefault(l, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int sum123 = nums1[i] + nums2[j] + nums3[k];
                    int sum4 = -sum123;
                    count += map.getOrDefault(sum4, 0);
                }
            }
        }

        return count;
    }
}


// TC: O(n) + O(n ^ 3) => O(n ^ 3)
// SC: O(n)

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum12 = nums1[i] + nums2[j];
                map.put(sum12, map.getOrDefault(sum12, 0) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum34 = nums3[i] + nums4[j];
                int sum12 = -sum34;
                count += map.getOrDefault(sum12, 0);
            }
        }

        return count;
    }
}

// TC: O(n ^ 2), SC: O(n)