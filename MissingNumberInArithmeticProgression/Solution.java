package MissingNumberInArithmeticProgression;

/**
 * In some array arr, the values were in arithmetic progression: the values arr[i+1] - arr[i] are all equal for every 0 <= i < arr.length - 1.
 *
 * Then, a value from arr was removed that was not the first or last value in the array.
 *
 * Return the removed value.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [5,7,11,13]
 * Output: 9
 * Explanation: The previous array was [5,7,9,11,13].
 * Example 2:
 *
 * Input: arr = [15,13,12]
 * Output: 14
 * Explanation: The previous array was [15,14,13,12].
 */
public class Solution {
    public int missingNumber(int[] arr) {
        int low = 0, high = arr.length, N = arr.length, d = (arr[N - 1] - arr[0]) / N;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == arr[0] + mid * d) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return arr[0] + low * d;
    }
}
