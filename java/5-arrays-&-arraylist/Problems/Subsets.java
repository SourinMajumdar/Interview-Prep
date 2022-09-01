// Link: https://leetcode.com/problems/subsets
// Solution: https://www.youtube.com/watch?v=kYY9DotIKlo

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int n = result.size();
            for (int i = 0; i < n; i++) {
                List<Integer> current = new ArrayList<>(result.get(i));
                current.add(num);
                result.add(current);
            }
        }

        return result;
    }
}

// TC: O(n * 2^n), SC: O(n * 2^n)

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // n

        for (int i = index; i < nums.length; i++) { // 2 ^ n
            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}

/*
TC: O(n * 2^n)

SC:
    - current array -> O(n)
    - output array -> O(n * 2^n)    (if not ignored)
    - recursion space -> O(n)

Total: O(n) + O(n * 2^n) + O(n)    OR just simply O(n) leaving the rest
 */