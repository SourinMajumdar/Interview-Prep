// Link: https://leetcode.com/problems/4sum/
// Solution: https://www.youtube.com/watch?v=4ggF3tXIAp0

// brute
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) return new ArrayList<>(); // it'll still be handled even if we don't write this condition
        Arrays.sort(nums);

        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j =  i + 1; j < n; j++) {
                for (int k =  j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }

        return new ArrayList(ans);
    }
}

// TC: O(n * logn) + O(n ^ 4) => O(n ^ 4)
// SC: O(1) - Ignoring output array


// optimal
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                long target2 = (long) target - (long) nums[i] - (long) nums[j];
                int lo = j + 1, hi = n - 1;

                while (lo < hi) {
                    int twoSum = nums[lo] + nums[hi];

                    if (twoSum < target2) lo++;
                    else if (twoSum > target2) hi--;
                    else {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]);
                        ans.add(quad);

                        while (lo < hi && nums[lo] == quad.get(2)) lo++;
                        while (lo < hi && nums[hi] == quad.get(3)) hi--;
                    }
                }

                while (j + 1 < n && nums[j] == nums[j + 1]) j++;
            }

            while (i + 1 < n && nums[i] == nums[i + 1]) i++;
        }

        return ans;
    }
}

// TC: O(n * logn) + O(n ^ 3) => O(n ^ 3)
// SC: O(1) - ignoring the output array


