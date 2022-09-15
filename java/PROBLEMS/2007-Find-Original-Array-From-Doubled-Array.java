// Link: https://leetcode.com/problems/find-original-array-from-doubled-array/

// https://www.youtube.com/watch?v=2EmGDorrAZU
class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];

        int[] ans = new int[n / 2];
        int[] countArr = new int[100001];

        for (int i : changed) countArr[i]++;

        int idx = 0;

        for (int i = 0; i < 100001; i++) {
            while (countArr[i] > 0 && i * 2 < 100001 && countArr[i * 2] > 0) {
                countArr[i]--;
                countArr[i * 2]--;
                ans[idx++] = i;
            }
        }

        for (int i : countArr) {
            if (i > 0) return new int[0];
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)


// https://www.youtube.com/watch?v=8FHgeioXH9c

class Solution {
    public int[] findOriginalArray(int[] changed) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        Arrays.sort(changed);

        for (int n : changed) {
            if (!q.isEmpty() && n == q.peek()) {
                q.poll();
            } else {
                q.offer(n * 2);
                list.add(n);
            }
        }

        return q.isEmpty() ? list.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}

// TC: O(n * logn) + O(n) => O(n * logn)
// SC: O(n) -> At worst case there would be no daouble and the queue will be fully filled up

