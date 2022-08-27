// Link: https://leetcode.com/problems/the-k-strongest-values-in-an-array/
// Solution: https://www.youtube.com/watch?v=mvegKS3IPUI

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> Math.abs(a - m) == Math.abs(b - m) ? b - a : Math.abs(b - m) - Math.abs(a - m)
        );

        for (int num : arr) {
            pq.offer(num);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}

// TC: O(n * logn) + O(n) => O(n * logn)
// SC: O(n + k)


class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        int[] ans = new int[k];
        int left = 0, right = arr.length - 1;
        int index = 0;

        while (index < k) {
            if (m - arr[left] > arr[right] - m) {
                ans[index++] = arr[left++];
            } else {
                ans[index++] = arr[right--];
            }
        }

        return ans;
    }
}

// TC: O(n * logn) + O(k) => O(n * logn)
// SC: O(k)

