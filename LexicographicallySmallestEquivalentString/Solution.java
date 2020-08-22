package LexicographicallySmallestEquivalentString;

/**
 * Given strings A and B of the same length, we say A[i] and B[i] are equivalent characters. For example, if A = "abc" and B = "cde", then we have 'a' == 'c', 'b' == 'd', 'c' == 'e'.
 *
 * Equivalent characters follow the usual rules of any equivalence relation:
 *
 * Reflexivity: 'a' == 'a'
 * Symmetry: 'a' == 'b' implies 'b' == 'a'
 * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'
 * For example, given the equivalency information from A and B above, S = "eed", "acd", and "aab" are equivalent strings, and "aab" is the lexicographically smallest equivalent string of S.
 *
 * Return the lexicographically smallest equivalent string of S by using the equivalency information from A and B.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "parker", B = "morris", S = "parser"
 * Output: "makkek"
 * Explanation: Based on the equivalency information in A and B, we can group their characters as [m,p], [a,o], [k,r,s], [e,i]. The characters in each group are equivalent and sorted in lexicographical order. So the answer is "makkek".
 * Example 2:
 *
 * Input: A = "hello", B = "world", S = "hold"
 * Output: "hdld"
 * Explanation:  Based on the equivalency information in A and B, we can group their characters as [h,w], [d,e,o], [l,r]. So only the second letter 'o' in S is changed to 'd', the answer is "hdld".
 * Example 3:
 *
 * Input: A = "leetcode", B = "programs", S = "sourcecode"
 * Output: "aauaaaaada"
 * Explanation:  We group the equivalent characters in A and B as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in S except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".
 */
public class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        int[] parent = new int[26];
        for (int i = 0;i < 26;++ i) {
            parent[i] = i;
        }

        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();

        for (int i = 0;i < arrA.length;++ i) {
            int aIdx = A.charAt(i) - 'a';
            int bIdx = B.charAt(i) - 'a';

            int rootA = union(parent, aIdx);
            int rootB = union(parent, bIdx);

            if (rootA < rootB) {
                parent[rootB] = rootA;
            } else {
                parent[rootA] = rootB;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < S.length();++ i) {
            int root = union(parent, S.charAt(i) - 'a');

            sb.append((char)('a' + root));
        }

        return sb.toString();
    }

    private int union(int[] parent, int x) {
        if (parent[x] == x) return x;
        else {
            parent[x] = union(parent, parent[x]);
            return parent[x];
        }
    }
}
