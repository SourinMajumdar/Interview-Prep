// Link: https://leetcode.com/problems/sort-the-students-by-their-kth-score/

// weekly 329, 22 Jan 2023
// Q2


class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}

// TC: O(n * logn), SC: O(1)
// n -> number of rows




class Solution {
    private class Pair {
        int[] a;
        int n;
        Pair(int[] a, int n) {
            this.a = a;
            this.n = n;
        }
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        // put each row along with it's k-th index (column) value in a max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.n - x.n);
        for (int i = 0; i < score.length; i++) {
            pq.offer(new Pair(score[i], score[i][k]));
        }

        // poll the arrays from the heap and and put them in score row-wise
        int i = 0;
        while (!pq.isEmpty()) {
            score[i++] = pq.poll().a;
        }

        return score;
    }
}

// TC: O(2 * n * logn) => O(n * logn)
// SC: O(m * n)
// n -> number of rows
// m -> number of columns