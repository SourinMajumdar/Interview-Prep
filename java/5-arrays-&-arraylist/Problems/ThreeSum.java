// Problem: https://leetcode.com/problems/3sum/
//

// Brute force (time limit exceeded)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if( nums[i] + nums[j] + nums[k] == 0){
                        if (!ans.contains(Arrays.asList(nums[i], nums[j], nums[k]))) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        }
                        // List<Integer> subset = new ArrayList<>();
                        // subset.add(nums[i]);
                        // subset.add(nums[j]);
                        // subset.add(nums[k]);
                        // if (!ans.contains(subset)) {
                        //     ans.add(subset);
                        // }
                    }
                }
            }
        }
        return ans;
    }
}

// TC: O(n^3 * logm), SC: O(m)
// m --> number of unique triplets



//