// Link: https://leetcode.com/problems/set-mismatch/


class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = 0, miss = 0;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) count++;
            }

            if (count == 2) dup = i;
            if (count == 0) miss = i;
        }

        return new int[] {dup, miss};
    }
}

// TC: O(n ^ 2), SC: O(1)



class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        int[] freq = new int[n];
        for (int i : nums) {
            freq[i - 1]++;
        }

        int dup = 0, miss = 0;
        for (int i = 0; i < n; i++) {
            if (freq[i] == 2) dup = i + 1;
            if (freq[i] == 0) miss = i + 1;
        }

        return new int[] {dup, miss};
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int dup = 0, miss = 0;

        for (int i : nums) {
            if (set.contains(i)) {
                dup = i;
            }
            set.add(i);
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                miss = i;
            }
        }

        return new int[] {dup, miss};
    }
}

// TC: O(n), SC: O(n)


// youtube.com/watch?v=c6cX1v-EQug

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];

        for (int i : nums) {
            int idx = Math.abs(i) - 1;
            if (nums[idx] < 0) {
                ans[0] = idx + 1;
            } else {
                nums[idx] = -nums[idx];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[1] = i + 1;
            }
        }

        return ans;
    }
}

// TC: O(n), SC: O(1)


// cyclic sort
class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIdx = nums[i] - 1;
            if (nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            }
            else i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[] {nums[i], i + 1};
            }
        }

        return new int[0];
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// TC: O(n) + O(n) ~ O(n)
// SC: O(1)