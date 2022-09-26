// Link: https://leetcode.com/problems/satisfiability-of-equality-equations/
// Solution: https://www.youtube.com/watch?v=uvSXZWtlwTo&t=733s

// https://leetcode.com/problems/satisfiability-of-equality-equations/discuss/234474/C%2B%2B-7-lines-with-picture-union-find
// https://leetcode.com/problems/satisfiability-of-equality-equations/discuss/2625039/LeetCode-The-Hard-Way-Explained-Line-By-Line

class Solution {
    int[] parent;
    int[] rank;

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (String eqn : equations) {
            if (eqn.charAt(1) == '=') {
                union(eqn.charAt(0) - 'a', eqn.charAt(3) - 'a');
            }
        }

        for (String eqn : equations) {
            if (eqn.charAt(1) == '!') {
                int lx = find(eqn.charAt(0) - 'a');
                int ly = find(eqn.charAt(3) - 'a');

                if (lx == ly) return false;
            }
        }

        return true;
    }

    public void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                parent[ly] = lx;
            }

            else if (rank[lx] > rank[ly]) {
                parent[lx] = ly;
            }

            else {
                parent[lx] = ly;
                rank[ly]++;
            }
        }
    }

    public int find(int x) {
        if (parent[x] == x) return x;

        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
}

// TC: O(n), SC: O(1)