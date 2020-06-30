package QueensThatCanAttacktheKing;

import java.util.*;

/**
 *
 On an 8x8 chessboard, there can be multiple Black Queens and one White King.

 Given an array of integer coordinates queens that represents the positions of the Black Queens, and a pair of coordinates king that represent the position of the White King, return the coordinates of all the queens (in any order) that can attack the King.
 */
public class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> results = new ArrayList<>();
        Set<Integer> queenPos = new HashSet<>();

        for (int[] queen : queens) {
            queenPos.add(queen[0] * 8 + queen[1]);
        }

        int[] dirs = new int[] {-1, 0, 1};

        for (int dirX : dirs) {
            for (int dirY : dirs) {
                if (dirX == 0 && dirY == 0) continue;

                int x0 = king[0] + dirX, y0 = king[1] + dirY;

                while (x0 >= 0 && x0 < 8 && y0 >= 0 && y0 < 8) {
                    if (queenPos.contains(x0 * 8 + y0)) {
                        List<Integer> result = new ArrayList<>();
                        result.add(x0);
                        result.add(y0);

                        results.add(result);
                        break;
                    }

                    x0 += dirX;
                    y0 += dirY;
                }
            }
        }

        return results;
    }
}
