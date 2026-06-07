class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add word into trie
    public void addWord(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    // Search word with '.' support
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        // Reached end of word
        if (index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);

        // Normal character
        if (ch != '.') {

            TrieNode child = node.children[ch - 'a'];

            if (child == null) {
                return false;
            }

            return dfs(word, index + 1, child);
        }

        // Dot case -> try all children
        for (TrieNode child : node.children) {

            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        }

        return false;
    }
}