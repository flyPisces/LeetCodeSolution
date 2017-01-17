package PacificAtlanticWaterFlow;

import java.util.*;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

 Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

 Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

 Note:
 The order of returned grid coordinates does not matter.
 Both m and n are less than 150.
 Example:

 Given the following 5x5 matrix:

 Pacific ~   ~   ~   ~   ~
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic

 Return:

 [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

 * Created by aoshen on 10/10/16.
 */
public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result=new ArrayList<int[]>();
        if(matrix.length==0||matrix[0].length==0) return result;
        int height=matrix.length,width=matrix[0].length;
        boolean [][]Pacific=new boolean[height][width],Atlantic=new boolean[height][width];
        for(int i=0;i<height;i++) {
            recursiveMark(Pacific,matrix,i,0,0); //We start from left edge of Pacific
            recursiveMark(Atlantic,matrix,i,width-1,0); //We start from right edge of Atlantic
        }
        for(int j=0;j<width;j++) {
            recursiveMark(Pacific,matrix,0,j,0); //We start from top edge of Pacific
            recursiveMark(Atlantic,matrix,height-1,j,0); //We start from bot edge of Atlantic
        }
        for(int i=0;i<height;i++)
            for(int j=0;j<width;j++){
                if(Pacific[i][j]&&Atlantic[i][j]) {
                    int []newOne={i,j};
                    result.add(newOne);
                }
            }
        return result;
    }

    public void recursiveMark(boolean [][]map,int[][]matrix,int i,int j,int pre){
        if(i<0||j<0||i>=map.length||j>=map[0].length) return;
        if(map[i][j]==true) return; //When this is visited before, we quit.
        int current=matrix[i][j];
        if(current>=pre) map[i][j]=true;
        else return;
        recursiveMark(map,matrix,i-1,j,current);
        recursiveMark(map,matrix,i+1,j,current);
        recursiveMark(map,matrix,i,j-1,current);
        recursiveMark(map,matrix,i,j+1,current);
    }
}
