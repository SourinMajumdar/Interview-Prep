// Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

// DFS 1

class Solution {
    int maxHeight = 0;  // max height that we'll return

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;     // if there no node, there is no height
        dfs(root, 0);          // we call dfs from root node
        return maxHeight;
    }

    public void dfs(TreeNode root, int currHeight) {
        // we currently don't know if the current node is null or not
        // so we update our max first with whatver height we have achieved so far
        maxHeight = Math.max(maxHeight, currHeight);

        if (root == null) return;       // if node is null, we return. We have already got our max height so far

        currHeight++;                   // node is not null means we gain +1 height by coming to the current node
        dfs(root.left, currHeight);     // call dfs for left child with current height
        dfs(root.right, currHeight);    // call dfs for right child with current height
    }
}


// DFS 2

// https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/300451/Java-Simple-2-lines-with-Notes-and-Picture

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

/*
    Go down all left and right kids, all the way to null kids that return 0.
        Then you return the MAX(left and right kids) + 1 for that level.

        Picture:

          3          return MAX(0 or 2) + 1     3
        /   \
       0     20      return MAX(0 or 1) + 1     2
            /  \
           0    7    return MAX(0 or 0) + 1     1
               / \
              0   0  return 0



// TC: O(n), SC: O(h)
*/



// BFS

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int height = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int itr = q.size();
            height++;

            while (itr-- > 0){
                TreeNode temp = q.poll();

                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }

        return height;
    }
}

// TC: O(n), SC: O(n)