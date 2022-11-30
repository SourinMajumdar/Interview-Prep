// Link: https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1

class Solution{
    public static void rearrange(long arr[], int n){
        long[] ans = new long[n];
        int i = 0, l = 0, r = n - 1;

        while (l <= r) {
            ans[i] = arr[r--];
            if (i + 1 < n) ans[i + 1] = arr[l++];
            i += 2;
        }

        for (i = 0; i < n; i++) {
            arr[i] = ans[i];
        }
    }
}

// TC: O(n), SC: O(n)



// TLE - 190/191
class Solution{
    public static void rearrange(long arr[], int n){
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int l = 0, r = n - 1;

        while (l < r) {
            minHeap.offer(arr[l++]);
            maxHeap.offer(arr[r--]);
        }

        long mid = 0;
        if (n % 2 == 1) mid = arr[n / 2];

        for (int i = 0; i < n - 1; i += 2) {
            arr[i] = maxHeap.poll();
            arr[i + 1] = minHeap.poll();
        }

        if (mid > 0) arr[n - 1] = mid;
    }
}

// TC: O(n * logn), SC: O(n)


