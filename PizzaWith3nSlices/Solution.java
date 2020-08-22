package PizzaWith3nSlices;

/**
 * There is a pizza with 3n slices of varying size, you and your friends will take slices of pizza as follows:
 *
 * You will pick any pizza slice.
 * Your friend Alice will pick next slice in anti clockwise direction of your pick.
 * Your friend Bob will pick next slice in clockwise direction of your pick.
 * Repeat until there are no more slices of pizzas.
 * Sizes of Pizza slices is represented by circular array slices in clockwise direction.
 *
 * Return the maximum possible sum of slice sizes which you can have.
 */
public class Solution {
    public int maxSizeSlices(int[] slices) {
        if (slices == null || slices.length == 0) return 0;
        if (slices.length == 3) {
            return Math.max(slices[0], Math.max(slices[1], slices[2]));
        }

        int N = slices.length / 3;
        int[][] dp1 = new int[slices.length][N + 1], dp2 = new int[slices.length][N + 1];

        dp1[1][1] = slices[0];
        for (int i = 2;i < slices.length;++ i) {
            for (int j = 1;j <= N;++ j) {
                dp1[i][j] = Math.max(dp1[i - 1][j], dp1[i - 2][j - 1] + slices[i - 1]);
            }
        }

        dp2[1][1] = slices[1];
        for (int i = 2;i < slices.length;++ i) {
            for (int j = 1;j <= N;++ j) {
                dp2[i][j] = Math.max(dp2[i - 1][j], dp2[i - 2][j - 1] + slices[i]);
            }
        }

        return Math.max(dp1[slices.length - 1][N], dp2[slices.length - 1][N]);
    }
}
