package NumberofOperationstoMakeNetworkConnected;

/**
 * There are n computers numbered from 0 to n-1 connected by ethernet cables connections forming a network where connections[i] = [a, b] represents a connection between computers a and b. Any computer can reach any other computer directly or indirectly through the network.
 *
 * Given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected. Return the minimum number of times you need to do this in order to make all the computers connected. If it's not possible, return -1.
 */
public class Solution {
    private int unionFind(int[] parent, int idx) {
        if (parent[idx] == idx) return idx;
        else parent[idx] = unionFind(parent, parent[idx]);

        return parent[idx];
    }

    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        for (int i = 0;i < n;++ i) {
            parent[i] = i;
        }

        int extraEdge = 0, components = 0;
        for (int[] connection : connections) {
            int p1 = unionFind(parent, connection[0]);
            int p2 = unionFind(parent, connection[1]);

            if (p1 == p2) extraEdge ++;
            else parent[p1] = p2;
        }

        for (int i = 0;i < n;++ i) {
            if (parent[i] == i) components ++;
        }

        if (components - 1 <= extraEdge) return components - 1;
        else return -1;
    }
}
