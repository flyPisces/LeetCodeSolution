package DivideChocolate;

/**
 * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
 *
 * You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces using K cuts, each piece consists of some consecutive chunks.
 *
 * Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
 *
 * Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
 * Output: 6
 * Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
 * Example 2:
 *
 * Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
 * Output: 1
 * Explanation: There is only one way to cut the bar into 9 pieces.
 * Example 3:
 *
 * Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
 * Output: 5
 * Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
 */
public class Solution {

    /**
     *         int left = 1, right = (int)1e9 / (K + 1);
     *         while (left < right) {
     *             int mid = (left + right + 1) / 2;
     *             int cur = 0, cuts = 0;
     *             for (int a : sweetness) {
     *             cur = cur + a;
     *                 if (cur >= mid) {
     *                     cur = 0;
     *                     if (++cuts > K) break;
     *                 }
     *             }
     *             if (cuts > K)
     *                 left = mid;
     *             else
     *                 right = mid - 1;
     *         }
     *         return left;
     * @param sweetness
     * @param K
     * @return
     */

    public int maximizeSweetness(int[] sweetness, int K) {
        int low = 1, high = 0;

        for (int sweet : sweetness) {
            high += sweet;
        }

        while (low < high) {
            int mid = low + (high - low) / 2 , sum = 0, cnt = 0;

            if (mid == low) {
                mid = mid + 1;
            }

            for (int num : sweetness) {
                sum += num;
                if (sum >= mid) {
                    cnt ++;
                    sum = 0;
                }
            }

            if (cnt >= K + 1) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.maximizeSweetness(new int[] {1,2,3,4,5,6,7,8,9}, 5);
    }
}
