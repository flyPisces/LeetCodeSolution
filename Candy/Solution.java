package Candy;

/**
 * There are N children standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    What is the minimum candies you must give?
 *
 * Created by aoshen on 4/13/16.
 */
public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int res = 0;

        int[] leftToRightNums = new int[ratings.length];
        int[] rightToLeftNums = new int[ratings.length];

        leftToRightNums[0] = 1;
        rightToLeftNums[ratings.length - 1] = 1;

        for (int i = 1;i < leftToRightNums.length;++ i) {
            if (ratings[i] > ratings[i - 1]) {
                leftToRightNums[i] = leftToRightNums[i - 1] + 1;
            } else {
                leftToRightNums[i] = 1;
            }
        }

        for (int j = rightToLeftNums.length - 2;j >= 0;-- j) {
            if (ratings[j] > ratings[j + 1]) {
                rightToLeftNums[j] = rightToLeftNums[j + 1] + 1;
            } else {
                rightToLeftNums[j] = 1;
            }
        }

        for (int k = 0;k != ratings.length;++ k) {
            res += Math.max(leftToRightNums[k], rightToLeftNums[k]);
        }

        return res;
    }
}
