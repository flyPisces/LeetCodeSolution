package ReplaceElementswithGreatestElementonRightSide;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 */
public class Solution {
    public int[] replaceElements(int[] arr) {
        int N = arr.length, max = arr[N - 1];
        arr[N - 1] = -1;

        for (int i = N - 2;i >= 0;-- i) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }

        return arr;
    }
}
