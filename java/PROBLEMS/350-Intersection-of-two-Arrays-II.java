// Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/
// Solution: https://www.youtube.com/watch?v=ZzshIcWLOH4

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq1 = getFreq(nums1), freq2 = getFreq(nums2);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < 1001; i++) {
            int count = Math.min(freq1[i], freq2[i]);
            while (count-- > 0) ans.add(i);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private int[] getFreq(int[] arr) {
        int[] freq = new int[1001];
        for (int i : arr) freq[i]++;
        return freq;
    }
}

// TC: O(n + m), SC: O(k) - k is the size of output array