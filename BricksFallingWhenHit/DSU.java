package BricksFallingWhenHit;

import java.util.Arrays;

public class DSU {
    int[] parent;
    int[] size;
    int[] rank;

    public DSU(int SIZE) {
        parent = new int[SIZE];
        for (int i = 0;i < SIZE;++ i) {
            parent[i] = i;
        }

        rank = new int[SIZE];

        size = new int[SIZE];
        Arrays.fill(size, 1);
    }

    public int root(int idx) {
        if (parent[idx] != idx) parent[idx] = root(parent[idx]);
        return parent[idx];
    }

    public void union(int x, int y) {
        int xx = root(x), yy = root(y);
        if (xx == yy) return;

        if (rank[xx] < rank[yy]) {
            int temp = xx;
            xx = yy;
            yy = temp;
        }

        if (rank[xx] == rank[yy]) {
            rank[xx] ++;
        }
        parent[yy] = xx;
        size[xx] += size[yy];
    }

    public int len(int x) {
        return size[root(x)];
    }

    public int top() {
        return len(parent.length - 1) - 1;
    }
}
