// Link: https://leetcode.com/problems/maximum-width-of-binary-tree/description/


// https://www.youtube.com/watch?v=ZbybYvcVLks


class Solution {
    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int minIdx = q.peek().index;
            int firstNodeIdx = 0, lastNodeIdx = 0;

            for (int i = 0; i < size; i++) {
                int currIdx = q.peek().index - minIdx;
                TreeNode currNode = q.poll().node;

                if (i == 0) firstNodeIdx = currIdx;
                if (i == size - 1) lastNodeIdx = currIdx;

                if (currNode.left != null) {
                    q.offer(new Pair(currNode.left, 2 * currIdx + 1));
                }
                if (currNode.right != null) {
                    q.offer(new Pair(currNode.right, 2 * currIdx + 2));
                }
            }

            int currWidth = lastNodeIdx - firstNodeIdx + 1;
            maxWidth = Math.max(maxWidth, currWidth);
        }

        return maxWidth;
    }
}

// TC: O(n), SC: O(n)




// TLE - 94/114

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxWidth = 0;

        while (!q.isEmpty()) {
            while (q.peek() == null && !q.isEmpty()) {
                q.poll();
            }
            while (q.peekLast() == null && !q.isEmpty()) {
                q.pollLast();
            }

            int currWidth = q.size();
            maxWidth = Math.max(currWidth, maxWidth);

            for (int i = 0; i < currWidth; i++) {
                TreeNode curr = q.poll();

                if (curr != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
                else {
                    q.add(null);
                    q.add(null);
                }
            }
        }

        return maxWidth;
    }
}