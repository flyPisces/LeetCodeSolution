package ClimbingStairs;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 */

public class Solution {
    public int climbStairs(int n) {
        if (0 == n) {
            return 0;
        } else if (1 == n) {
            return 1;
        } else if (2 == n) {
            return 2;
        }
              
        
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        
        for (int i = 2;i < n;++ i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        
        return arr[n - 1];
    }
}
