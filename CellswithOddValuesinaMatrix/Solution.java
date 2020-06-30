package CellswithOddValuesinaMatrix;

/**
 * Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
 *
 * Return the number of cells with odd values in the matrix after applying the increment to all indices.
 */
public class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] rows  = new boolean[n];
        boolean[] cols = new boolean[m];

        for (int[] indice : indices) {
            rows[indice[0]] ^= true;
            cols[indice[1]] ^= true;
        }

        int result = 0;
        for (int i = 0;i < n;++ i) {
            for (int j = 0;j < m;++ j) {
                result += rows[i] ^ cols[j] == true ? 1 : 0;
            }
        }

        return result;
    }
}
