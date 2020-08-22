package MinimumSwapstoGroupAllOneTogether;

/**
 * Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,0,1,0,1]
 * Output: 1
 * Explanation:
 * There are 3 ways to group all 1's together:
 * [1,1,1,0,0] using 1 swap.
 * [0,1,1,1,0] using 2 swaps.
 * [0,0,1,1,1] using 1 swap.
 * The minimum is 1.
 * Example 2:
 *
 * Input: [0,0,0,1,0]
 * Output: 0
 * Explanation:
 * Since there is only one 1 in the array, no swaps needed.
 * Example 3:
 *
 * Input: [1,0,1,0,1,0,0,1,1,0,1]
 * Output: 3
 * Explanation:
 * One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].
 */
public class Solution {
    public int minSwaps(int[] data) {
        if (data.length < 3) return 0;

        int totalOne = 0, left = 0, right = 0, max = 0, oneCount = 0;

        for (int num : data) {
            if (num == 1) {
                totalOne ++;
            }
        }

        while (right < data.length) {
            while (right < data.length && right - left < totalOne) {
                if (data[right ++] == 1) {
                    oneCount ++;
                }
            }

            max = Math.max(max, oneCount);
            if (right == data.length) break;

            if (data[left ++] == 1) {
                -- oneCount;
            }
        }

        return totalOne - max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.minSwaps(new int[] {1,0,1,0,1}));
    }
}
