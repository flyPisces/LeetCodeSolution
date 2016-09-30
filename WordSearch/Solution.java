package WordSearch;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 *
 * Created by aoshen on 5/11/16.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 ||
                word == null || word.length() == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0;i != board.length;++ i) {
            for (int j = 0;j != board[0].length;++ j) {
                if (dfs_helper(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs_helper(char[][] board, boolean[][] visited, int row, int col, String word, int index) {

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if (visited[row][col]) {
            return false;
        }

        if (word.charAt(index) != board[row][col]) {
            return false;
        }

        visited[row][col] = true;
        boolean result = dfs_helper(board, visited, row - 1, col, word, index + 1) ||
                dfs_helper(board, visited, row + 1, col, word, index + 1) ||
                dfs_helper(board, visited, row, col + 1, word, index + 1) ||
                dfs_helper(board, visited, row, col - 1, word, index + 1);
        visited[row][col] = false;

        return result;
    }
}
