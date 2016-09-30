package CloneGraph;

import java.util.*;

/**
 * Created by aoshen on 7/26/16.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>();}
}
