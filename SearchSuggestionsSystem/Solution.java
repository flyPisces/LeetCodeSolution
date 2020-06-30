package SearchSuggestionsSystem;

import com.sun.org.apache.regexp.internal.RE;

import javax.management.RuntimeErrorException;
import java.util.*;

/**
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 *
 * Return list of lists of the suggested products after each character of searchWord is typed.
 *
 *
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 * Example 2:
 *
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * Example 3:
 *
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * Example 4:
 *
 * Input: products = ["havana"], searchWord = "tatiana"
 * Output: [[],[],[],[],[],[],[]]
 */
public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> results = new ArrayList<>();

        Trie root = new Trie();
        Trie curr = root;

        for (String product : products) {
            curr = root;
            for (char c : product.toCharArray()) {
                if (curr.sub[c - 'a'] == null) {
                    curr.sub[c - 'a'] = new Trie();
                }
                curr = curr.sub[c - 'a'];
                curr.suggestions.offer(product);
                Collections.sort(curr.suggestions);
                if (curr.suggestions.size() > 3) {
                    curr.suggestions.pollLast();
                }
            }
        }

        curr = root;
        for (char c : searchWord.toCharArray()) {
            if (curr != null) {
                curr = curr.sub[c - 'a'];
            }

            results.add(curr == null ? new ArrayList<>() : curr.suggestions);
        }

        return results;
    }

    class Trie {
        Trie[] sub = new Trie[26];
        LinkedList<String> suggestions = new LinkedList<>();
    }
}
