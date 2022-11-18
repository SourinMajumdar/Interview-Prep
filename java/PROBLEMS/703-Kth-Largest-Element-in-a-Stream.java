// Link: https://leetcode.com/problems/kth-largest-element-in-a-stream/

class KthLargest {

    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for (int n : nums) pq.offer(n);
        while (pq.size() > k) pq.poll();
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}

// TC:
//    offer            polling            add()
// O(n * logn) + O((n - k) * log(n)) + O(m * logk)
// => O(n * logn) + O(m * logk)

// say m be the number of calls made to add()

// SC: O(n)