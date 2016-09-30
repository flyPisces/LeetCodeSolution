package PrefixTree;

/**
 * Created by aoshen on 6/13/16.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        TrieNode cur = root;
        for (int i = 0;i < word.length();++ i) {
            int index = word.charAt(i) - 'a';

            if (cur.nodes[index] == null) {
                cur.nodes[index] = new TrieNode();
            }

            cur = root.nodes[index];
        }

        cur.term = word;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null) {
            return false;
        }

        TrieNode cur = root;
        for (int i = 0;i < word.length();++ i) {
            int index = word.charAt(i) - 'a';
            cur = cur.nodes[index];

            if (cur == null) return false;
        }

        return cur.term.equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }

        TrieNode cur = root;
        for (int i = 0;i < prefix.length();++ i) {
            int index = prefix.charAt(i) - 'a';
            cur = cur.nodes[index];

            if (cur == null) return false;
        }

        return true;
    }
}
