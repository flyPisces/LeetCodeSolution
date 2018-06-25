package PrefixandSuffixSearch;

/**
 * Given many words, words[i] has weight i.

 Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix).
 It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

 Examples:
 Input:
 WordFilter(["apple"])
 WordFilter.f("a", "e") // returns 0
 WordFilter.f("b", "") // returns -1
 */
public class Solution {
    TrieNode trie;
    public Solution(String[] words) {
        trie = new TrieNode();
        for (int weight = 0; weight < words.length; ++weight) {
            String word = words[weight] + "{";
            for (int i = 0; i < word.length(); ++i) {
                TrieNode cur = trie;
                cur.weight = weight;
                for (int j = i; j < 2 * word.length() - 1; ++j) {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.children[k] == null)
                        cur.children[k] = new TrieNode();
                    cur = cur.children[k];
                    cur.weight = weight;
                }
            }
        }
    }
    public int f(String prefix, String suffix) {
        TrieNode cur = trie;
        for (char letter: (suffix + '{' + prefix).toCharArray()) {
            if (cur.children[letter - 'a'] == null) return -1;
            cur = cur.children[letter - 'a'];
        }
        return cur.weight;
    }
}
