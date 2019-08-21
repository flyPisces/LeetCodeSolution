package AvailableCapturesforRook;

/**
 *
 On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.

 The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.

 Return the number of pawns the rook can capture in one move.
 */
public class Solution {
    public int numRookCaptures(char[][] board) {
        int x = -1, y = -1;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
            if(x != -1) break;
        }

        // board[x][y] is the rook
        // search above, if bishop is hit, break, if pawn is hit, increase counter and break
        int counter = 0;
        for(int i = x; i >= 0; i--) {
            if(board[i][y] == 'B') break;
            if(board[i][y] == 'p') {
                counter++;
                break;
            }
        }
        //search below
        for(int i = x; i < 8; i++) {
            if(board[i][y] == 'B') break;
            if(board[i][y] == 'p') {
                counter++;
                break;
            }
        }
        // search left
        for(int i = y; i >= 0; i--) {
            if(board[x][i] == 'B') break;
            if(board[x][i] == 'p') {
                counter++;
                break;
            }
        }
        // search right
        for(int i = y; i < 8; i++) {
            if(board[x][i] == 'B') break;
            if(board[x][i] == 'p') {
                counter++;
                break;
            }
        }
        return counter;
    }
}
