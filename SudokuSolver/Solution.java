package SudokuSolver;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

    Empty cells are indicated by the character '.'.

    You may assume that there will be only one unique solution.
 *
 *  Created by aoshen on 4/2/16.
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        solver_helper(board);
    }

    public boolean solver_helper(char[][] board) {
        for (int i = 0;i != 9;++ i) {
            for (int j = 0;j != 9;++ j) {
                if (board[i][j] == '.') {
                    for (char c = '1';c <= '9';++ c) {
                        if (isNumberAllowed(board, i, j, c)) {
                            board[i][j] = c;

                            if (solver_helper(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isNumberAllowed(char[][] board, int x, int y, char c) {

        for (int i = 0;i != 9;++ i) {
            if (board[i][y] == c) {
                return false;
            }
        }

        for (int i = 0;i != 9;++ i) {
            if (c == board[x][i]) {
                return false;
            }
        }

        int start_row = (x / 3) * 3;
        int start_col = (y / 3) * 3;

        for (int i = 0;i != 3;++ i) {
            for (int j = 0;j != 3;++ j) {
                if (board[start_row + i][start_col + j] == c) {
                    return false;
                }
            }
        }

        return true;
    }
}
