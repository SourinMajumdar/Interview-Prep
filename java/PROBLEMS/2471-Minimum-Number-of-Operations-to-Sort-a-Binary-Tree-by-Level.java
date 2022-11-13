// Link: https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/

// Weekly 319, 13 Nov 2022
// Q3


class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int min = 0;

        while (!q.isEmpty()){
            int size = q.size();
            int[] arr = new int[size];
            int i = 0;

            while (size-- > 0){
                TreeNode node = q.poll();
                arr[i++] = node.val;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            min += minSwaps(arr);
        }

        return min;
    }

    public int minSwaps(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);
        boolean[] visited = new boolean[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || map.get(nums[i]) == i) {
                continue;
            }

            int j = i, cycleSize = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = map.get(nums[j]);
                cycleSize++;
            }

            if(cycleSize > 0) {
                ans += (cycleSize - 1);
            }
        }

        return ans;
    }
}


// TC: O(h * n * logn)
// SC: O(n)

