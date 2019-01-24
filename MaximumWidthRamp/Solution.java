package MaximumWidthRamp;

/**
 * Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

 Find the maximum width of a ramp in A.  If one doesn't exist, return 0.



 Example 1:

 Input: [6,0,8,2,1,5]
 Output: 4
 Explanation:
 The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
 Example 2:

 Input: [9,8,1,0,1,9,4,0,4,1]
 Output: 7
 Explanation:
 The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
 */
public class Solution {
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        int i, j , max = 0;
        int[] maxR = new int[n], minL = new int[n];
        minL[0] = A[0];
        for (i = 1; i < n; i++){
            minL[i] = Math.min(A[i], minL[i - 1]);
        }
        maxR[n - 1] = A[n - 1];
        for (j = n - 2; j >= 0; j--){
            maxR[j] = Math.max(A[j], maxR[j + 1]);
        }
        i = 0; j = 0;
        while (i < n && j < n){
            if (minL[i] <= maxR[j]){
                max = Math.max(max, j - i);
                j++;
            }else{
                i++;
            }
        }
        return max;
    }
}
