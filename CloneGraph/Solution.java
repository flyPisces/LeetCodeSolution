package CloneGraph;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 1
 / \
 /   \
 0 --- 2
 / \
 \_/

 *
 * Created by aoshen on 7/26/16.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        UndirectedGraphNode newHead = null;
        Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap = new HashMap<>();
        Queue<UndirectedGraphNode> bfsList = new LinkedList<>();

        bfsList.offer(node);
        newHead = new UndirectedGraphNode(node.label);
        cloneMap.put(node, newHead);

        while (!bfsList.isEmpty()) {
            UndirectedGraphNode top = bfsList.poll();

            for (UndirectedGraphNode nbh : top.neighbors) {
                if (!cloneMap.containsKey(nbh)) {
                    UndirectedGraphNode cloneNbh = new UndirectedGraphNode(nbh.label);
                    cloneMap.put(nbh, cloneNbh);
                    cloneMap.get(top).neighbors.add(cloneNbh);
                    bfsList.offer(nbh);
                } else {
                    cloneMap.get(top).neighbors.add(cloneMap.get(nbh));
                }
            }
        }

        return newHead;
    }
}
