package CatandMouse;

import java.util.*;

/**
 *
 A game on an undirected graph is played by two players, Mouse and Cat, who alternate turns.

 The graph is given as follows: graph[a] is a list of all nodes b such that ab is an edge of the graph.

 Mouse starts at node 1 and goes first, Cat starts at node 2 and goes second, and there is a Hole at node 0.

 During each player's turn, they must travel along one edge of the graph that meets where they are.  For example, if the Mouse is at node 1, it must travel to any node in graph[1].

 Additionally, it is not allowed for the Cat to travel to the Hole (node 0.)

 Then, the game can end in 3 ways:

 If ever the Cat occupies the same node as the Mouse, the Cat wins.
 If ever the Mouse reaches the Hole, the Mouse wins.
 If ever a position is repeated (ie. the players are in the same position as a previous turn, and it is the same player's turn to move), the game is a draw.
 Given a graph, and assuming both players play optimally, return 1 if the game is won by Mouse, 2 if the game is won by Cat, and 0 if the game is a draw.


 */
public class Solution {
    HashMap<String, Integer> mapping = new HashMap<>();

    public int catMouseGame(int[][] graph) {
        return dfs(1, 2, true, graph);
    }

    private int dfs(int mouse, int cat, boolean m_turn, int[][] graph) {
        String key = String.valueOf(mouse) + ":" + String.valueOf(cat) + ":" + String.valueOf(m_turn);

        if (mapping.containsKey(key)) {
            return mapping.get(key);
        }
        mapping.put(key, 0);

        if (m_turn) {
            return mousePlay(key, mouse, cat, m_turn, graph);
        } else {
            return catPlay(key, mouse, cat, m_turn, graph);
        }
    }

    private int mousePlay(String key, int mouse, int cat, boolean m_turn, int[][] graph) {
        for (int next : graph[mouse]) {
            if (next == 0) {
                mapping.put(key, 1);
                return 1;
            }
        }

        int result = 2;

        for (int next : graph[mouse]) {
            if (next == cat) continue;
            int tmp = dfs(next, cat, false, graph);

            if (tmp == 1) {
                result = 1;
                break;
            }

            if (tmp == 0) {
                result = 0;
            }
        }

        mapping.put(key, result);
        return result;
    }

    private int catPlay(String key, int mouse, int cat, boolean m_turn, int[][] graph) {
        for (int next : graph[cat]) {
            if (next == mouse) {
                mapping.put(key, 2);
                return 2;
            }
        }

        int result = 1;

        for (int next : graph[cat]) {
            if (next == 0) continue;
            int tmp = dfs(mouse, next, true, graph);

            if (tmp == 2) {
                result = 2;
                break;
            }

            if (tmp == 0) {
                result = 0;
            }
        }

        mapping.put(key, result);
        return result;
    }
}
