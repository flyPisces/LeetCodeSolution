package PrefixandSuffixSearch;

public class TrieNode {
    TrieNode[] children;
    int weight;

    public TrieNode() {
        children = new TrieNode[27];
        weight = 0;
    }
}
