// Link: https://leetcode.com/problems/top-k-frequent-elements/
// Solution:

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b) -> map.get(b) - map.get(a));

        int[] ans = new int[k];
        int ind = 0;
        while(ind < k) {
            ans[ind] = list.get(ind);
            ind++;
        }

        return ans;
    }
}

// TC: O(n + k) + O(n * logn) => O(n * logn)
// SC: O(n + k)

