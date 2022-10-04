// Link: https://leetcode.com/problems/sort-even-and-odd-indices-independently/

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> oddIdx = new ArrayList<>(),
        evenIdx = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) evenIdx.add(nums[i]);
            else oddIdx.add(nums[i]);
        }

        Collections.sort(evenIdx);
        Collections.sort(oddIdx, (a, b) -> b - a);

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) nums[i] = evenIdx.remove(0);
            else nums[i] = oddIdx.remove(0);
        }

        return nums;
    }
}

// TC: 2 * (O(n) + O(n * logn)) => O(n * logn)
// SC: O(n)


class Solution {
    public int[] sortEvenOdd(int[] nums) {
        PriorityQueue<Integer> evenIdx = new PriorityQueue<>(),
                oddIdx = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) evenIdx.offer(nums[i]);
            else oddIdx.offer(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) nums[i] = evenIdx.poll();
            else nums[i] = oddIdx.poll();
        }

        return nums;
    }
}

// TC: O(n * logn), SC: O(n)