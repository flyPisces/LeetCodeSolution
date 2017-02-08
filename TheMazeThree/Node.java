package TheMazeThree;

/**
 * Created by aoshen on 2/5/17.
 */
public class Node implements Comparable<Node> {
    int x, y, step;
    String route;

    public Node(int _x, int _y, int _step, String _route) {
        x= _x;
        y = _y;
        step = _step;
        route = _route;
    }

    public boolean equals(Node a, Node b) {
        return a.x == b.x && a.y == b.y;
    }

    public int compareTo(Node that) {
        return this.step - that.step;
    }
}
