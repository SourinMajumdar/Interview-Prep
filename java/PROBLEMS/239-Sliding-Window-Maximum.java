// Link: https://leetcode.com/problems/sliding-window-maximum/


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];

            for (int j = i; j < k + i; j++) {
                if (nums[j] > max) max = nums[j];
            }

            ans[i] = max;
        }

        return ans;
    }
}

// TC: O((n - k) * k)) => O(n * k)
// SC: O(1) -> if we ignore the output array


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;

        int left = 0, right = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        while (right < k) pq.offer(nums[right++]);

        int[] ans = new int[nums.length - k + 1];

        while (right < nums.length) {
            ans[left] = pq.peek();
            pq.remove(nums[left++]);
            pq.offer(nums[right++]);
        }

        ans[left] = pq.peek();

        return ans;
    }
}

// TC: O(k *  logk) + O((n - k) * logk) => O(n * logk)
// SC: O(k)



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        int left = 0, right = 0;

        while (right < nums.length) {
            if (q.isEmpty()) q.add(nums[right]);
            else {
                while (!q.isEmpty() && nums[right] > q.peekLast()) {
                    q.pollLast();
                }
                q.add(nums[right]);
            }

            if (right - left + 1 == k) {
                ans[left] = q.peek();
                if (nums[left] == q.peek()) q.pollFirst();
                left++;
            }

            right++;
        }

        return ans;
    }
}

// TC: O(n), SC: O(k)

