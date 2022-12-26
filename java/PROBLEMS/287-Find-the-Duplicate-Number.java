// Link: https://leetcode.com/problems/find-the-duplicate-number/
//

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                ans = nums[i];
            }
        }

        return ans;
    }
}

// TC: O(nlogn) + O(n) ~ O(n * logn)
// SC: O(1)


class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = nums[0];

        for (int num : nums) {
            if (set.contains(num)) {
                ans = num;
                break;
            }

            set.add(num);
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)


// Negative marking approach
class Solution {
    public int findDuplicate(int[] nums) {
        int ans = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ans = Math.abs(nums[i]);
                break;
            }
            nums[index] = -nums[index];
        }

        return ans;
    }
}

// TC: O(n), SC: O(1)


// Floyd's cycle detection technique

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

// TC: O(n), SC: O(1)


// Cycle sort
class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIdx = nums[i] - 1;
            if (nums[i] != nums[correctIdx]) {
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
            else i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }

        return 0;
    }
}

// TC: O(n) + O(n) ~ O(n)
// SC: O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int correctIdx = nums[i] - 1;
                if (nums[i] != nums[correctIdx]) {
                    int temp = nums[i];
                    nums[i] = nums[correctIdx];
                    nums[correctIdx] = temp;
                }
                else {
                    return nums[i];
                }
            }
            else i++;

        }

        return 0;
    }
}

// TC: O(n), SC: O(1)
