// Link: https://leetcode.com/problems/find-k-closest-elements/
// Solution: https://www.youtube.com/watch?v=C_kHKUJuK0Y

// Priority Queue
class Solution {
    private class Node {
        private int diff;
        private int index;

        public Node(int index, int diff) {
            this.diff = diff;
            this.index = index;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> (a.diff == b.diff) ? b.index - a.index : b.diff - a.diff
        );

        for (int i = 0; i < arr.length; i++) {
            pq.offer(new Node(i, Math.abs(x - arr[i])));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(arr[pq.poll().index]);
        }

        Collections.sort(ans);
        return ans;
    }
}

// TC: O(n * logn) + O(k) + O(k * logk)
// SC: O(k)


// Two pointers
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - 1;

        while (high - low >= k) {
            if (Math.abs(arr[low] - x) > Math.abs(arr[high] - x)) {
                low++;
            }
            else high--;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = low; i <= high; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}

// TC: O(n), SC: O(k)