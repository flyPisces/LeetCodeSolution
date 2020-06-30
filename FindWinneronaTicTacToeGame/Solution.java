package FindWinneronaTicTacToeGame;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
 *
 * Here are the rules of Tic-Tac-Toe:
 *
 * Players take turns placing characters into empty squares (" ").
 * The first player A always places "X" characters, while the second player B always places "O" characters.
 * "X" and "O" characters are always placed into empty squares, never on filled ones.
 * The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they mark their respective character in the order in which A and B play.
 *
 * Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements to play return "Pending".
 *
 * You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.
 *
 *
 *
 * Example 1:
 *
 * Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * Output: "A"
 * Explanation: "A" wins, he always plays first.
 * "X  "    "X  "    "X  "    "X  "    "X  "
 * "   " -> "   " -> " X " -> " X " -> " X "
 * "   "    "O  "    "O  "    "OO "    "OOX"
 * Example 2:
 *
 * Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * Output: "B"
 * Explanation: "B" wins.
 * "X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
 * "   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
 * "   "    "   "    "   "    "   "    "   "    "O  "
 * Example 3:
 *
 * Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * Output: "Draw"
 * Explanation: The game ends in a draw since there are no moves to make.
 * "XXO"
 * "OOX"
 * "XOX"
 * Example 4:
 *
 * Input: moves = [[0,0],[1,1]]
 * Output: "Pending"
 * Explanation: The game has not finished yet.
 * "X  "
 * " O "
 * "   "
 */
public class Solution {
    public String tictactoe(int[][] moves) {
        int[] Arows = new int[3], Acols = new int[3], Brows = new int[3], Bcols = new int[3];
        int ADiagonal = 0, ARDiagonal = 0, BDiagonal = 0, BRDiagonal = 0;

        int time = 0;

        for (int[] move : moves) {
            int r = move[0], c = move[1];

            if (time % 2 == 0) {
                Arows[r] ++;
                Acols[c] ++;
                if (r == c) ADiagonal ++;
                if (r + c == 2) ARDiagonal ++;

                if (Arows[r] == 3 || Acols[c] == 3 || ADiagonal == 3 || ARDiagonal == 3) return "A";
            } else {
                Brows[r] ++;
                Bcols[c] ++;
                if (r == c) BDiagonal ++;
                if (r + c == 2) BRDiagonal ++;

                if (Brows[r] == 3 || Bcols[c] == 3 || BDiagonal == 3 || BRDiagonal == 3) return "B";
            }

            time ++;
        }

        return time == 9 ? "Draw" : "Pending";
    }
}
