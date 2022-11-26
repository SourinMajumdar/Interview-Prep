// Link: https://practice.geeksforgeeks.org/problems/construct-binary-tree-from-string-with-bracket-representation/1
// https://www.youtube.com/watch?v=vwvr2W3FSn0

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static Node treeFromString(String s) {
        int[] idx = new int[]{0};
        return dfs(s, idx);
    }

    static Node dfs(String s, int[] idx){
        if (idx[0] >= s.length() || s.charAt(idx[0])== ')'){
            idx[0]++;
            return null;
        }

        int num = 0;
        while (idx[0] < s.length() && Character.isDigit(s.charAt(idx[0]))){
            num = num * 10 + (s.charAt(idx[0]) - '0');
            idx[0]++;
        }

        Node root = new Node(num);

        if (idx[0] < s.length() && s.charAt(idx[0]) == '('){
            idx[0]++;
            root.left = dfs(s, idx);
        }

        if (idx[0] < s.length() && s.charAt(idx[0]) == '('){
            idx[0]++;
            root.right = dfs(s, idx);
        }

        idx[0]++;

        return root;
    }
}

// TC: O(n), SC: O(n)