package MaximumofAbsoluteValueExpression;

/**
 * Given two arrays of integers with equal lengths, return the maximum value of:

 |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|

 where the maximum is taken over all 0 <= i, j < arr1.length.



 Example 1:

 Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 Output: 13
 Example 2:

 Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 Output: 20
 */
public class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int result = Integer.MIN_VALUE;
        int[] nums = new int[] {-1, 1};
        int[] dp = new int[arr1.length];

        for (int num1 : nums) {
            for (int num2 : nums) {
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                for (int i = 0;i < dp.length;++ i) {
                    dp[i] = num1 * arr1[i] + num2 * arr2[i] + i;
                    max = Math.max(max, dp[i]);
                    min = Math.min(min, dp[i]);
                }

                result = Math.max(result, max - min);
            }
        }


        return result;
    }
}
