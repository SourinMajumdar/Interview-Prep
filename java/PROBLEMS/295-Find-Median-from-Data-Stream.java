// Link: https://leetcode.com/problems/find-median-from-data-stream/


class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        int n = list.size();

        if (n % 2 == 1) return (double) list.get(n / 2);

        double median = list.get(n / 2) + list.get(n / 2 - 1);
        return median / 2;
    }
}

// TC: O(k * n * logn), SC: O(n)



class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0 || maxHeap.peek() >= num) {
            maxHeap.offer(num);
        }
        else minHeap.offer(num);

        balance();
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        else if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        }
        else return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    private void balance() {
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
        else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
}

// TC: O(n * logn), SC: O(n)