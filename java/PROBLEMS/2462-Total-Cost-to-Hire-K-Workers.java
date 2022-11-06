// Link: https://leetcode.com/problems/total-cost-to-hire-k-workers/

// Weekly 218, 6 Nov 2022
// Q3


class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;

        PriorityQueue<Pair<Integer, Integer>> leftCandidates = new PriorityQueue<>(
            (a, b) -> {
                return a.getKey() == b.getKey() ? a.getValue() - b.getValue() : a.getKey() - b.getKey();
            }
        );

        PriorityQueue<Pair<Integer, Integer>> rightCandidates = new PriorityQueue<>(
            (a, b) -> {
                return a.getKey() == b.getKey() ? a.getValue() - b.getValue() : a.getKey() - b.getKey();
            }
        );

        int n = costs.length;
        int i = 0;

        for (i = 0; i < candidates; i++) {
            leftCandidates.offer(new Pair(costs[i], i));
        }

        int leftBoundary = i;
        int remaining = Math.min(n - i, candidates);

        for (i = 0; i < remaining; i++) {
            rightCandidates.offer(new Pair(costs[n - i - 1], n - i - 1));
        }

        int rightBoundary = n - 1 - remaining;

        while (k > 0 && !leftCandidates.isEmpty() && !rightCandidates.isEmpty()) {
            Pair<Integer, Integer> leftPair = leftCandidates.peek();
            Pair<Integer, Integer> rightPair = rightCandidates.peek();

            if (leftPair.getKey() <= rightPair.getKey()) {
                cost += leftPair.getKey();
                leftCandidates.poll();

                if (leftBoundary <= rightBoundary) {
                    leftCandidates.offer(new Pair(costs[leftBoundary], leftBoundary));
                    leftBoundary++;
                }
            }
            else {
                cost += rightPair.getKey();
                rightCandidates.poll();

                if (leftBoundary <= rightBoundary) {
                    rightCandidates.offer(new Pair(costs[rightBoundary], rightBoundary));
                    rightBoundary--;
                }
            }

            k--;
        }

        if (k > 0) {
            PriorityQueue<Pair<Integer, Integer>> pq = leftCandidates;

            if (leftCandidates.isEmpty()) pq = rightCandidates;

            while (k-- > 0) {
                cost += pq.poll().getKey();
            }
        }

        return cost;
    }
}


// TC: O(n * logn), SC: O(