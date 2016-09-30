package PrefixTree;

/**
 * Created by aoshen on 6/13/16.
 */
public class TrieNode {

    String term = null;
    TrieNode[] nodes = null;

    public TrieNode() {
        term = "";
        nodes = new TrieNode[26];
    }
}
