package NQueens;

import java.util.*;
/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

    For example,
    There exist two distinct solutions to the 4-queens puzzle:

    [
     [".Q..",  // FreqStack 1
      "...Q",
      "Q...",
      "..Q."],

     ["..Q.",  // FreqStack 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
 */

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<List<String>>();
        
        if (n > 0) {
            int[] queenPos = new int[n];
            solver_helper(results, queenPos, 0);
        }
        
        return results;
    }
    
    public void solver_helper(List<List<String>> results, int[] queenPos, int pos) {
        if (pos == queenPos.length) {
            results.add(getQueenGraph(queenPos));
            return;
        }
        
        for (int i = 0;i != queenPos.length;++ i) {
            if (isAllowed(queenPos, pos, i)) {
                queenPos[pos] = i;
                solver_helper(results, queenPos, pos + 1);
            }
        }
    }
    
    public boolean isAllowed(int[] queenPos, int pos, int val) {
        for (int i = 0;i < pos;++ i) {
            if (queenPos[i] == val || Math.abs(queenPos[i] - val) == Math.abs(pos - i)) {
                return false;
            }
        }
        
        return true;
    }
    
    public List<String> getQueenGraph(int[] queenPos) {
        List<String> result = new ArrayList<String>();
        
        for (int i = 0;i != queenPos.length;++ i) {
            int pos = queenPos[i];
            
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j != queenPos.length;++ j) {
                if (j != pos) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            result.add(sb.toString());
        }
        
        return result;
    }
}
