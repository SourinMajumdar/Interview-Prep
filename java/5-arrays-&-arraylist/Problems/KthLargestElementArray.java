// Problem: https://leetcode.com/problems/kth-largest-element-in-an-array/
// Solution: https://www.youtube.com/watch?v=yAs3tONaf3s

// ----------------------------------------------------------------
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

// TC: O(NlogN), SC: O(1)

// ----------------------------------------------------------------

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if ( nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }
}

// TC: O(Nlogk), SC: O(k)


// ----------------------------------------------------------------

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);

            if ( pq.size() > k ) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}

// TC: , SC: O(k)