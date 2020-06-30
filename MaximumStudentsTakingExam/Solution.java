package MaximumStudentsTakingExam;

import java.util.*;

/**
 * Given a m * n matrix seats  that represent seats distributions in a classroom. If a seat is broken, it is denoted by '#' character otherwise it is denoted by a '.' character.
 *
 * Students can see the answers of those sitting next to the left, right, upper left and upper right, but he cannot see the answers of the student sitting directly in front or behind him. Return the maximum number of students that can take the exam together without any cheating being possible..
 *
 * Students must be placed in seats in good condition.
 */
public class Solution {
    public int maxStudents(char[][] seats) {
        int ROW = seats.length, COL = seats[0].length;
        int[][] memo = new int[ROW][1 << COL];
        for (int i = 0;i < ROW;++ i) {
            Arrays.fill(memo[i], -1);
        }

        return getMax(seats, memo, 0, 0);
    }

    private int getMax(char[][] seats, int[][] memo, int row, int prevMask) {
        if (row == seats.length) return 0;
        if (memo[row][prevMask] != -1) return memo[row][prevMask];

        List<Integer> masks = new ArrayList<>();
        dfs(seats[row], 0, prevMask, 0, masks);

        int max = 0;

        for (int mask : masks) {
            max = Math.max(max, Integer.bitCount(mask) + getMax(seats, memo, row + 1, mask));
        }

        memo[row][prevMask] = max;
        return memo[row][prevMask];
    }

    private void dfs(char[] rowSeats, int pos, int prevMask, int currMask, List<Integer> masks) {
        if (pos == rowSeats.length) {
            masks.add(currMask);
            return;
        }

        dfs(rowSeats, pos + 1, prevMask, currMask, masks);

        if (rowSeats[pos] != '#' && (pos == 0 || ((((currMask & (1 << (pos - 1))) == 0) && ((prevMask & (1 << (pos - 1))) == 0))))
            && (pos == rowSeats.length - 1 || ((((prevMask & (1 << (pos + 1))) == 0))))) {
            currMask |= (1 << pos);
            dfs(rowSeats, pos + 1, prevMask, currMask, masks);
            currMask ^= (1 << pos);
        }
    }
}
