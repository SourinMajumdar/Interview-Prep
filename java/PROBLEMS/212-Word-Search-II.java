// Link: https://leetcode.com/problems/word-search-ii/


// Brute force

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();

        for (String word : words)
            for (int i = 0; i < board.length; i++)
                for (int j = 0; j < board[0].length; j++)
                    if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word))
                        if (!ans.contains(word)) ans.add(word);

        return ans;
    }

    public boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(count)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean found =
        dfs(board, i + 1, j, count + 1, word) ||
        dfs(board, i - 1, j, count + 1, word) ||
        dfs(board, i, j + 1, count + 1, word) ||
        dfs(board, i, j - 1, count + 1, word);

        board[i][j] = temp;

        return found;
    }
}

// TC: O(w * m * n), SC: O(m * n)


// Trie
class Solution {
    private class TrieNode {
        private TrieNode[] children;
        private String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String w : words) {
            TrieNode p = root;

            for (char c : w.toCharArray()) {
                int i = c - 'a';

                if (p.children[i] == null) {
                    p.children[i] = new TrieNode();
                }

                p = p.children[i];
            }

            p.word = w;
        }

        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board,  i, j, root, res);

        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        char c = board[i][j];

        if (c == ' ' || p.children[c - 'a'] == null) return;

        p = p.children[c - 'a'];

        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;      // de-duplicate
        }

        board[i][j] = ' ';

        dfs(board, i - 1, j, p, res);
        dfs(board, i, j - 1, p, res);
        dfs(board, i + 1, j, p, res);
        dfs(board, i, j + 1, p, res);

        board[i][j] = c;
    }
}


