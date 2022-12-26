// Link: https://leetcode.com/problems/sort-an-array/

// Using priority queue
class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int  i : nums) {
            pq.offer(i);
        }

        int i = 0;
        while (!pq.isEmpty()) {
            nums[i++] = pq.poll();
        }

        return nums;
    }
}

// TC: O(n * logn), SC: O(n)


// Bubble sort (TLE - 10/18 passed)
class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return nums;
    }
}

// TC: O(n^2), SC: O(1)

// Selection sort (TLE - 12/18 passed)
class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int lastIdx = nums.length - i - 1;
            int maxIdx = 0;

            for (int j = 0; j <= lastIdx; j++) {
                if (nums[j] > nums[maxIdx]) {
                    maxIdx = j;
                }
            }

            int temp = nums[lastIdx];
            nums[lastIdx] = nums[maxIdx];
            nums[maxIdx] = temp;
        }

        return nums;
    }
}

// TC: O(n^2), SC: O(1)