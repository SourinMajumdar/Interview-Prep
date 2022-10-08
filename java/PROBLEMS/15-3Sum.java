// Problem: https://leetcode.com/problems/3sum/
// Solution: https://www.youtube.com/watch?v=onLoX6Nhvmg&t=1281s

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

// OR
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList(ans);
    }
}

// TC: O(n * logn) + O(n^3 * logk) => O(n^3 * logk)
// SC: O(K) - k is the number of unique triplets



// little optimisation
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                int newTarget = 0 - nums[i] - nums[j];
                if (set.contains(newTarget)) {
                    ans.add(Arrays.asList(nums[i], newTarget, nums[j]));
                }
                else set.add(nums[j]);
            }
        }

        return new ArrayList(ans);
    }
}

// TC: O(n * logn) + O(n^2 * logk) => O(n^2 * logk)
// SC: O(K) - k is the number of unique triplets



// Optimised solution:
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = nums.length - 1;
                int sum = -nums[i];

                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (hi > lo && nums[hi] == nums[hi - 1]) hi--;

                        lo++; hi--;
                    }

                    else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }

        return ans;
    }
}

// TC: O(n ^ 2), SC: O(k) - k is the number of unique triplets
// Auxiliary space: O(1)