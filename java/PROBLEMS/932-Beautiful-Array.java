// Link: https://leetcode.com/problems/beautiful-array/
// Solution: https://www.youtube.com/watch?v=7-RZ0Lw6VRg

class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        while (list.size() < n) {
            List<Integer> temp = new ArrayList<>();

            for (int i : list) {
                if (2*i -1 <= n) temp.add(2*i - 1);
            }

            for (int i : list) {
                if (2*i <= n) temp.add(2 * i);
            }

            list = temp;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}


// TC:
// SC: O(n) +
