// Link: https://leetcode.com/problems/design-add-and-search-words-data-structure/

class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isComplete = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        return _search(word, 0, root);
    }

    public boolean _search(String word, int i, TrieNode node) {
        if (node == null) return false;
        if (i == word.length()) {
            return node.isComplete;
        }
        char c = word.charAt(i);
        if (c == '.') {
            for (TrieNode tn : node.children) {
                if (_search(word, i + 1, tn)) {
                    return true;
                }
            }
        } else {
            if (_search(word, i + 1, node.children[c - 'a'])) {
                return true;
            }
        }
        return false;
    }

    class TrieNode {
        boolean isComplete;
        TrieNode[] children;
        public TrieNode() {
            isComplete = false;
            children = new TrieNode[26];
        }
    }
}

// TC: O(n), SC: O(n)

