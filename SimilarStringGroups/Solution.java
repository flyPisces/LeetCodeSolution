package SimilarStringGroups;

/**
 * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.

 For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

 Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

 We are given a list A of unique strings.  Every string in A is an anagram of every other string in A.  How many groups are there?

 Example 1:

 Input: ["tars","rats","arts","star"]
 Output: 2

 */
class Solution {
    public int numSimilarGroups(String[] A) {
        int N = A.length;
        int W = A[0].length();
        DSU dsu = new DSU(N);

        // if (N < W*W) { // If few words, then check for pairwise similarity: O(N^2 W)
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                if (similar(A[i], A[j]))
                    dsu.union(i, j);

        int ans = 0;
        for (int i = 0; i < N; ++i)
            if (dsu.parent[i] == i) ans++;

        return ans;
    }

    public boolean similar(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); ++i)
            if (word1.charAt(i) != word2.charAt(i))
                diff++;
        return diff <= 2;
    }

}

class DSU {
    int[] parent;
    public DSU(int N) {
        parent = new int[N];
        for (int i = 0; i < N; ++i)
            parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
