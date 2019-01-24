package MostStonesRemovedwithSameRoworColumn;

import java.util.*;

/**
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

 Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

 What is the largest possible number of moves we can make?



 Example 1:

 Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 Output: 5
 Example 2:

 Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 Output: 3
 Example 3:

 Input: stones = [[0,0]]
 Output: 0
 */
public class Solution {
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(20000);

        for (int[] stone : stones) {
            dsu.union(stone[0], 10000 + stone[1]);
        }

        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(dsu.find(stone[0]));
        }

        return stones.length - set.size();
    }
}

class DSU {
    int[] parent;

    DSU(int N) {
        parent = new int[N];

        for (int i = 0;i < N;++ i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}