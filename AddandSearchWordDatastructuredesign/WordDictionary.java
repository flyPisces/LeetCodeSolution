package AddandSearchWordDatastructuredesign;

/**
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true


 * Created by aoshen on 8/11/16.
 */
public class WordDictionary {
    class TrieNode {
        TrieNode[] arr;
        boolean isLeaf;

        public TrieNode() {
            arr = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;

        for (int i = 0;i < word.length();++ i) {
            int diff = word.charAt(i) - 'a';

            if (curr.arr[diff] != null) {
                curr = curr.arr[diff];
            } else {
                curr.arr[diff] = new TrieNode();
                curr = curr.arr[diff];
            }
        }

        curr.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode root, String word, int start) {
        if (root.isLeaf && start == word.length()) {
            return true;
        }

        if (start >= word.length()) {
            return false;
        }

        if (word.charAt(start) == '.') {
            for (TrieNode node : root.arr) {
                if (node == null) continue;
                if (dfs(node, word, start + 1)) {
                    return true;
                }
            }
        } else {
            int idx = word.charAt(start) - 'a';
            if (root.arr[idx] != null) {
                return dfs(root.arr[idx], word, start + 1);
            }
        }

        return false;
    }
}
