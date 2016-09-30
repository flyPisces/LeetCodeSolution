package NQueensTwo;

/**
 * Follow up for N-Queens problem.

    Now, instead outputting board configurations, return the total number of distinct solutions.

 * Created by aoshen on 4/16/16.
 */
public class Solution {
    public int totalNQueens(int n) {
        int[] res = {0};
        if(n<=0)
            return res[0];

        int [] columnVal = new int[n];

        DFS_helper(n,res,0,columnVal);
        return res[0];
    }

    public void DFS_helper(int nQueens, int[] res, int row, int[] columnVal){
        if(row == nQueens){
            res[0] += 1;
        }else{
            for(int i = 0; i < nQueens; i++){
                columnVal[row] = i;//(row,columnVal[row)==>(row,i)

                if(isValid(row,columnVal))
                    DFS_helper(nQueens, res, row+1, columnVal);
            }
        }
    }

    public boolean isValid(int row, int [] columnVal) {
        for (int i = 0; i < row; i++) {
            if (columnVal[row] == columnVal[i]
                    || Math.abs(columnVal[row] - columnVal[i]) == row - i)
                return false;
        }
        return true;
    }
}
