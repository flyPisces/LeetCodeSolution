package MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a m x n binary matrix mat. In one step, you can choose one cell and flip it and all the four neighbours of it if they exist (Flip is changing 1 to 0 and 0 to 1). A pair of cells are called neighboors if they share one edge.
 *
 * Return the minimum number of steps required to convert mat to a zero matrix or -1 if you cannot.
 *
 * Binary matrix is a matrix with all cells equal to 0 or 1 only.
 *
 * Zero matrix is a matrix with all cells equal to 0.
 *
 *
 */
public class Solution {
    int[][]dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {0, 0}};

    public int minFlips(int[][] mat) {
        int M = mat.length, N = mat[0].length;

        int start = 0;
        for (int i = 0;i < M;++ i) {
            for (int j = 0;j < N;++ j) {
                start = start | (mat[i][j] << (i * N + j));
            }
        }

        Queue<Integer> list = new LinkedList<>();
        list.offer(start);
        int step = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        for (;!list.isEmpty();++ step) {
            int size = list.size();

            for (int i = 0;i < size;++ i) {
                int top = list.poll();
                if (top == 0) return step;

                for (int j = 0;j < M;++ j) {
                    for (int k = 0;k < N;++ k) {
                        int next = top;

                        for (int[] dir : dirs) {
                            int newX = j + dir[0], newY = k + dir[1];

                            if (newX >= 0 && newX < M && newY >= 0 && newY < N) {
                                next = next ^ (1 << (newX * N + newY));
                            }
                        }

                        if (visited.add(next)) {
                            list.offer(next);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.minFlips(new int[][] {{0}, {1}, {1}}));
    }
}
