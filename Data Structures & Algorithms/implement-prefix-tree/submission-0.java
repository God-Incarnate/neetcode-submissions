class PrefixTree {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    // Insert word
    public void insert(String word) {

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

    // Search exact word
    public boolean search(String word) {

        TrieNode node = traverse(word);

        return node != null && node.isEnd;
    }

    // Search prefix
    public boolean startsWith(String prefix) {

        return traverse(prefix) != null;
    }

    // Common traversal helper
    private TrieNode traverse(String str) {

        TrieNode current = root;

        for (char ch : str.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }
}