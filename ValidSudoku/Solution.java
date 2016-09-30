package ValidSudoku;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Created by aoshen on 5/7/16.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        boolean[] flags = new boolean[9];


        // check horizontal
        for (int i = 0;i != 9;++ i) {
            resetFlagsArr(flags);

            for (int j = 0;j != 9;++ j) {
                if (board[i][j] == '.') {
                    continue;
                }

                int index = board[i][j] - '1';
                if (index < 0 || index > 8) {
                    return false;
                }

                if (flags[index] != true) {
                    flags[index] = true;
                } else {
                    return false;
                }
            }
        }

        // check vertical
        for (int i = 0;i != 9;++ i) {
            resetFlagsArr(flags);

            for (int j = 0;j != 9;++ j) {
                if (board[j][i] == '.') {
                    continue;
                }

                int index = board[j][i] - '1';

                if (index < 0 || index > 8) {
                    return false;
                }

                if (flags[index] == false) {
                    flags[index] = true;
                } else {
                    return false;
                }
            }
        }

        // check each small 3*3 area
        for (int i = 0;i < 9;i = i + 3) {
            for (int j = 0;j < 9;j = j + 3) {
                resetFlagsArr(flags);

                for (int m = 0;m < 3;++ m) {
                    for (int n = 0;n < 3;++ n) {
                        if (board[i + m][j + n] == '.') {
                            continue;
                        }

                        int index = board[i + m][j + n] - '1';

                        if (index < 0 || index > 8) {
                            return false;
                        }

                        if (flags[index] == false) {
                            flags[index] = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void resetFlagsArr(boolean[] flags) {
        for (int i = 0;i != 9;++ i) {
            flags[i] = false;
        }
    }
}
