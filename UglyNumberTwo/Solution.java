package UglyNumberTwo;

/**
 * Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number.

 * Created by aoshen on 5/18/16.
 */
public class Solution {
    public int nthUglyNumber(int n) {

        int[] arr = new int[n];
        arr[0] = 1;
        int twoIndex = 0;
        int threeIndex = 0;
        int fiveIndex = 0;

        for (int i = 1;i < n;++ i) {
            int min = Math.min(2 * arr[twoIndex], Math.min(3 * arr[threeIndex], 5 * arr[fiveIndex]));
            arr[i] = min;

            if (min == 2 * arr[twoIndex]) {
                twoIndex ++;
            }

            if (min == 3 * arr[threeIndex]) {
                threeIndex ++;
            }

            if (min == 5 * arr[fiveIndex]) {
                fiveIndex ++;
            }
        }

        return arr[n - 1];
    }
}
