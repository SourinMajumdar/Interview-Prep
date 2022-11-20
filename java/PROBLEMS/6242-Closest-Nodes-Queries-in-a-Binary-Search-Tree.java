// Link: https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/

// Weekly 320, 20 Nov 2022
// Q2

// BFS + BS
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                if (stack.isEmpty()) break;
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int n : queries) {
            ans.add(getFloorCeil(list, n));
        }

        return ans;
    }

    public List<Integer> getFloorCeil(List<Integer> nums, int target) {
        int lo = 0, hi = nums.size() - 1;
        int floor = -1, ceil = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums.get(mid) == target) {
                return Arrays.asList(target, target) ;
            }
            else if (target < nums.get(mid)) {
                ceil = nums.get(mid);
                hi = mid - 1;
            }
            else {
                floor = nums.get(mid);
                lo = mid + 1;
            }
        }

        return Arrays.asList(floor, ceil);
    }
}

// TC: O(n) + O(m * logn))
// n -> number of nodes in binary tree
// m -> length of queries

// SC: O(n + m)



// DFS + BS
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);

        List<List<Integer>> ans = new ArrayList<>();

        for (int n : queries) {
            ans.add(getFloorCeil(list, n));
        }

        return ans;
    }

    public List<Integer> getFloorCeil(List<Integer> nums, int target) {
        int lo = 0, hi = nums.size() - 1;
        int floor = -1, ceil = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums.get(mid) == target) {
                return Arrays.asList(target, target) ;
            }
            else if (target < nums.get(mid)) {
                ceil = nums.get(mid);
                hi = mid - 1;
            }
            else {
                floor = nums.get(mid);
                lo = mid + 1;
            }
        }

        return Arrays.asList(floor, ceil);
    }

    public void inorder(List<Integer> list, TreeNode root){
        if(root == null) return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}

// TC: O(n) + O(m * logn))
// n -> number of nodes in binary tree
// m -> length of queries

// SC: O(n + m)


// treeset + dfs
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();

        inorder(set,root);

        for (int n : queries) {
            int floor = set.floor(n) == null ? -1 : set.floor(n);
            int ceil = set.ceiling(n) == null ? - 1: set.ceiling(n);

            ans.add(Arrays.asList(floor, ceil));
        }

        return ans;

    }

    public void inorder(TreeSet set, TreeNode root){
        if(root == null) return;

        inorder(set, root.left);
        set.add(root.val);
        inorder(set, root.right);
    }
}

// TC: O(n * logn) + O(m * logn) => O((n + m) * logn))
// SC: O(n + m)
